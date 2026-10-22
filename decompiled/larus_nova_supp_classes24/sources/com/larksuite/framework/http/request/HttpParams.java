package com.larksuite.framework.http.request;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class HttpParams implements Serializable {
    public static final boolean IS_REPLACE = true;
    public static final MediaType MEDIA_TYPE_STREAM = null;
    public static final String RAW_TYPE_JSON = "application/json;charset=utf-8";
    public static final String RAW_TYPE_PLAIN = "text/plain;charset=utf-8";
    public static final String RAW_TYPE_STREAM = "application/octet-stream";
    private static final long serialVersionUID = 7369819159227055048L;
    public LinkedHashMap<String, List<FileWrapper>> fileParamsMap;
    public LinkedHashMap<String, String> urlParamsMap;

    public static class FileWrapper implements Serializable {
        private static final long serialVersionUID = -2356139899636767776L;
        public String contentType;
        public File file;
        public String fileName;
        public long fileSize;

        public String toString() {
            return "FileWrapper{file=" + this.file + ", fileName=" + this.fileName + ", contentType=" + this.contentType + ", fileSize=" + this.fileSize + "}";
        }

        private void readObject(ObjectInputStream r1) throws IOException, ClassNotFoundException {
            r1.defaultReadObject();
            this.contentType = (String) r1.readObject();
        }

        private void writeObject(ObjectOutputStream r2) throws IOException {
            r2.defaultWriteObject();
            r2.writeObject(this.contentType.toString());
        }

        public FileWrapper(File r1, String r2, String r3) {
            this.file = r1;
            this.fileName = r2;
            this.contentType = r3;
            this.fileSize = r1.length();
        }
    }

    static {
        MEDIA_TYPE_STREAM = MediaType.parse(RAW_TYPE_STREAM);
    }

    public void clear() {
        this.urlParamsMap.clear();
        this.fileParamsMap.clear();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r1 = this.urlParamsMap.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Map.Entry<String, String> r2 = r1.next();
        if (r0.length() <= 0) goto L8;
        r0.append("&");
    L8:
        r0.append(r2.getKey());
        r0.append("=");
        r0.append(r2.getValue());
        goto L4
    L9:
        Iterator<Map.Entry<String, List<FileWrapper>>> r3 = this.fileParamsMap.entrySet().iterator();
    L11:
        if (r3.hasNext() == false) goto L17;
        Map.Entry<String, List<FileWrapper>> r4 = r3.next();
        if (r0.length() <= 0) goto L15;
        r0.append("&");
    L15:
        r0.append(r4.getKey());
        r0.append("=");
        r0.append(r4.getValue());
        goto L11
    L17:
        return r0.toString();
    }

    public HttpParams() {
        this.urlParamsMap = new LinkedHashMap();
        this.fileParamsMap = new LinkedHashMap();
    }

    public static String guessMimeType(String r3) {
        String r4 = URLConnection.getFileNameMap().getContentTypeFor(r3.replace("#", ""));
        if (r4 != null) goto L6;
        return RAW_TYPE_STREAM;
    L6:
        return r4;
    }

    public void put(HttpParams r3) {
        if (r3 == null) goto L14;
        LinkedHashMap<String, String> r0 = r3.urlParamsMap;
        if (r0 != null) goto L6;
    L8:
        LinkedHashMap<String, List<FileWrapper>> r1 = r3.fileParamsMap;
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.isEmpty() == true) goto L16;
        this.fileParamsMap.putAll(r3.fileParamsMap);
        return;
    L16:
        return;
    L6:
        if (r0.isEmpty() == true) goto L8;
        this.urlParamsMap.putAll(r3.urlParamsMap);
        goto L8
    }

    public void remove(String r1) {
        removeUrl(r1);
        removeFile(r1);
    }

    public void removeFile(String r2) {
        this.fileParamsMap.remove(r2);
    }

    public void removeUrl(String r2) {
        this.urlParamsMap.remove(r2);
    }

    public HttpParams(String r2, File r3) {
        this.urlParamsMap = new LinkedHashMap();
        this.fileParamsMap = new LinkedHashMap();
        put(r2, r3);
    }

    public final void a(String r2, String r3) {
        if (r2 == null) goto L6;
        if (r3 == null) goto L7;
        this.urlParamsMap.put(r2, r3);
        return;
    L7:
        return;
    }

    public void put(Map<String, String> r3, boolean... r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isEmpty() == true) goto L12;
        Iterator<Map.Entry<String, String>> r5 = r3.entrySet().iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        Map.Entry<String, String> r0 = r5.next();
        put(r0.getKey(), r0.getValue(), r4);
        goto L8
    L13:
        return;
    }

    public void putFileParams(String r2, List<File> r3) {
        if (r2 == null) goto L10;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L13;
        Iterator<File> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        put(r2, r4.next());
        goto L8
    L14:
        return;
    L13:
        return;
    }

    public void putFileWrapperParams(String r2, List<FileWrapper> r3) {
        if (r2 == null) goto L10;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L13;
        Iterator<FileWrapper> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        put(r2, r4.next());
        goto L8
    L14:
        return;
    L13:
        return;
    }

    public void putUrlParams(String r2, List<String> r3) {
        if (r2 == null) goto L10;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L13;
        Iterator<String> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        a(r2, r4.next());
        goto L8
    L14:
        return;
    L13:
        return;
    }

    public HttpParams(String r2, String r3) {
        this.urlParamsMap = new LinkedHashMap();
        this.fileParamsMap = new LinkedHashMap();
        a(r2, r3);
    }

    public void put(String r3, FileWrapper r4) {
        if (r3 == null) goto L6;
        if (r4 == null) goto L7;
        put(r3, r4.file, r4.fileName, r4.contentType);
        return;
    L7:
        return;
    }

    public void put(String r2, File r3) {
        put(r2, r3, r3.getName());
    }

    public void put(String r2, char r3, boolean... r4) {
        if (r4 != null) goto L4;
    L6:
        a(r2, String.valueOf(r3));
        return;
    L4:
        if (r4.length <= 0) goto L6;
        String r5 = String.valueOf(r3);
        boolean r6 = r4[0];
        a(r2, r5);
    }

    public void put(String r2, double r3, boolean... r5) {
        if (r5 != null) goto L4;
    L6:
        a(r2, String.valueOf(r3));
        return;
    L4:
        if (r5.length <= 0) goto L6;
        String r4 = String.valueOf(r3);
        boolean r6 = r5[0];
        a(r2, r4);
    }

    public void put(String r2, float r3, boolean... r4) {
        if (r4 != null) goto L4;
    L6:
        a(r2, String.valueOf(r3));
        return;
    L4:
        if (r4.length <= 0) goto L6;
        String r5 = String.valueOf(r3);
        boolean r6 = r4[0];
        a(r2, r5);
    }

    public void put(String r2, int r3, boolean... r4) {
        if (r4 != null) goto L4;
    L6:
        a(r2, String.valueOf(r3));
        return;
    L4:
        if (r4.length <= 0) goto L6;
        String r5 = String.valueOf(r3);
        boolean r6 = r4[0];
        a(r2, r5);
    }

    public void put(String r2, long r3, boolean... r5) {
        if (r5 != null) goto L4;
    L6:
        a(r2, String.valueOf(r3));
        return;
    L4:
        if (r5.length <= 0) goto L6;
        String r4 = String.valueOf(r3);
        boolean r6 = r5[0];
        a(r2, r4);
    }

    public void put(String r2, boolean r3, boolean... r4) {
        if (r4 != null) goto L4;
    L6:
        a(r2, String.valueOf(r3));
        return;
    L4:
        if (r4.length <= 0) goto L6;
        String r5 = String.valueOf(r3);
        boolean r6 = r4[0];
        a(r2, r5);
    }

    public void put(String r2, String r3, boolean... r4) {
        if (r4 != null) goto L4;
    L6:
        a(r2, r3);
        return;
    L4:
        if (r4.length <= 0) goto L6;
        boolean r5 = r4[0];
        a(r2, r3);
    }

    public void put(String r2, File r3, String r4) {
        put(r2, r3, r4, guessMimeType(r4));
    }

    public void put(String r3, File r4, String r5, String r6) {
        if (r3 == null) goto L8;
        List<FileWrapper> r0 = this.fileParamsMap.get(r3);
        if (r0 != null) goto L6;
        r0 = new ArrayList();
        this.fileParamsMap.put(r3, r0);
    L6:
        r0.add(new FileWrapper(r4, r5, r6));
        return;
    }
}

package com.ss.android.lark.image.entity;

import android.text.TextUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class Image implements Serializable {
    private static final long serialVersionUID = -2514439118477067808L;
    private ByteString crypto;
    private String fsUnit;
    private int height;
    private String key;
    private ResourceCleanScene resourceCleanScene;
    boolean resourceIsCleaned;
    private File thumbnailCache;
    private String token;
    private Type type;
    private List<String> urls;
    private int width;

    public static final enum Type extends Enum<Type> {
        public static final Type ENCRYPTED = null;
        public static final Type NORMAL = null;
        public static final /* synthetic */ Type[] a = null;
        private int value;

        static {
            Type r0 = new Type("NORMAL", 0, 1);
            NORMAL = r0;
            Type r1 = new Type("ENCRYPTED", 1, 2);
            ENCRYPTED = r1;
            a = new Type[]{r0, r1};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type forNumber(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return null;
        L9:
            return ENCRYPTED;
        L11:
            return NORMAL;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public static Type valueOf(int r0) {
            return forNumber(r0);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.key, this.urls, Integer.valueOf(this.width), Integer.valueOf(this.height), this.token, this.type, this.thumbnailCache, this.crypto, this.fsUnit, Boolean.valueOf(this.resourceIsCleaned), this.resourceCleanScene});
    }

    public boolean isEmpty() {
        if (TextUtils.isEmpty(this.key) == false) goto L9;
        List<String> r0 = this.urls;
        if (r0 != null) goto L7;
    L8:
        return true;
    L7:
        if (r0.isEmpty() == true) goto L8;
    L9:
        return false;
    }

    public Image() {
        this.key = "";
        this.urls = new ArrayList();
        this.resourceIsCleaned = false;
        this.resourceCleanScene = null;
    }

    public ByteString getCrypto() {
        return this.crypto;
    }

    public String getFsUnit() {
        return this.fsUnit;
    }

    public int getHeight() {
        return this.height;
    }

    public String getKey() {
        return this.key;
    }

    public ResourceCleanScene getResourceCleanScene() {
        return this.resourceCleanScene;
    }

    public File getThumbnailCache() {
        return this.thumbnailCache;
    }

    public String getToken() {
        return this.token;
    }

    public Type getType() {
        return this.type;
    }

    public List<String> getUrls() {
        return this.urls;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isResourceIsCleaned() {
        return this.resourceIsCleaned;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L35:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L35;
        Image r6 = (Image) r5;
        if (this.width == r6.width) goto L13;
    L33:
        return false;
    L13:
        if (this.height != r6.height) goto L33;
        if (this.resourceIsCleaned != r6.resourceIsCleaned) goto L33;
        if (Objects.equals(this.key, r6.key) == false) goto L33;
        if (Objects.equals(this.urls, r6.urls) == false) goto L33;
        if (Objects.equals(this.token, r6.token) == false) goto L33;
        if (this.type != r6.type) goto L33;
        if (Objects.equals(this.thumbnailCache, r6.thumbnailCache) == false) goto L33;
        if (Objects.equals(this.crypto, r6.crypto) == false) goto L33;
        if (Objects.equals(this.fsUnit, r6.fsUnit) == false) goto L33;
        if (this.resourceCleanScene != r6.resourceCleanScene) goto L33;
        return true;
    }

    public void setCrypto(ByteString r1) {
        this.crypto = r1;
    }

    public void setFsUnit(String r1) {
        this.fsUnit = r1;
    }

    public void setHeight(int r1) {
        this.height = r1;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setResourceCleanScene(ResourceCleanScene r1) {
        this.resourceCleanScene = r1;
    }

    public void setResourceIsCleaned(boolean r1) {
        this.resourceIsCleaned = r1;
    }

    public void setThumbnailCache(File r1) {
        this.thumbnailCache = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setType(Type r1) {
        this.type = r1;
    }

    public void setUrls(List<String> r1) {
        this.urls = r1;
    }

    public void setWidth(int r1) {
        this.width = r1;
    }
}

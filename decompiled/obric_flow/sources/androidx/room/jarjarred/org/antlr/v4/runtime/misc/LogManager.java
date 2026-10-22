package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LogManager {
    protected List<Record> records;

    public static class Record {
        String component;
        StackTraceElement location;
        String msg;
        long timestamp;

        public Record() {
            this.timestamp = System.currentTimeMillis();
            this.location = new Throwable().getStackTrace()[0];
        }

        public String toString() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(this.timestamp)) + " " + this.component + " " + this.location.getFileName() + ":" + this.location.getLineNumber() + " " + this.msg;
        }
    }

    public LogManager() {
    }

    public static void main(String[] r5) throws IOException {
        LogManager r10 = new LogManager();
        r10.log("atn", "test msg");
        r10.log("dfa", "test msg 2");
        System.out.println(r10);
        r10.save();
    }

    public void log(String r5, String r10) {
        Record r11 = new Record();
        r11.component = r5;
        r11.msg = r10;
        if (this.records != null) goto L5;
        this.records = new ArrayList();
    L5:
        this.records.add(r11);
    }

    public void save(String r5) throws IOException {
        BufferedWriter r10 = new BufferedWriter(new FileWriter(r5));
        r10.write(toString());     // Catch: Throwable -> L6
        r10.close();
        return;
    L6:
        th = move-exception;
        r10.close();
        throw th;
    }

    public String toString() {
        if (this.records != null) goto L6;
        return "";
    L6:
        String r5 = System.getProperty("line.separator");
        StringBuilder r10 = new StringBuilder();
        Iterator<Record> r11 = this.records.iterator();
    L8:
        if (r11.hasNext() == false) goto L11;
        r10.append(r11.next());
        r10.append(r5);
        goto L8
    L11:
        return r10.toString();
    }

    public String save() throws IOException {
        String r5 = "./antlr-" + new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss").format(new Date()) + ".log";
        save(r5);
        return r5;
    }

    public void log(String r5) {
        log(null, r5);
    }
}

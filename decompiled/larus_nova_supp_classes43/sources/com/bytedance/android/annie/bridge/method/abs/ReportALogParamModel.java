package com.bytedance.android.annie.bridge.method.abs;

import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.android.annie.bridge.method.util.EnumJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u0016B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel;", "", "", com.bytedance.android.ec.core.event.a.KEY_MSG, "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$Level;", "level", "Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$Level;", "b", "()Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$Level;", "setLevel", "(Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$Level;)V", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG, "d", "setTag", "Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$a;", "codePosition", "Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$a;", "a", "()Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$a;", "setCodePosition", "(Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$a;)V", "<init>", "()V", "Level", "LevelAdapter", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class ReportALogParamModel {

    @SerializedName("codePosition")
    private a codePosition;

    @SerializedName("level")
    @JsonAdapter(LevelAdapter.class)
    private Level level;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_MSG)
    private String message;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG)
    private String tag;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$Level;", "", "", "toString", "Companion", "a", "Error", "Warn", "Debug", "Verbose", "Info", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Level extends Enum<Level> {
        public static final a Companion = null;
        public static final Level Debug = null;
        public static final Level Error = null;
        public static final Level Info = null;
        public static final Level Verbose = null;
        public static final Level Warn = null;
        public static final /* synthetic */ Level[] a = null;

        public static final class a {
            public a() {
            }
        }

        public static Level valueOf(String r1) {
            return (Level) r27.a.a(Level.class, r1);
        }

        public static Level[] values() {
            return (Level[]) a.clone();
        }

        static {
            Level r0 = new Level("Error", 0);
            Error = r0;
            Level r1 = new Level("Warn", 1);
            Warn = r1;
            Level r10 = new Level("Debug", 2);
            Debug = r10;
            Level r11 = new Level("Verbose", 3);
            Verbose = r11;
            Level r12 = new Level("Info", 4);
            Info = r12;
            a = new Level[]{r0, r1, r10, r11, r12};
            Companion = new a();
        }

        @Override // java.lang.Enum
        public String toString() {
            if (this != Error) goto L6;
            return IHostStyleUIDepend.TOAST_TYPE_ERROR;
        L6:
            if (this != Warn) goto L9;
            return IHostStyleUIDepend.TOAST_TYPE_WARN;
        L9:
            if (this != Debug) goto L12;
            return "debug";
        L12:
            if (this != Verbose) goto L15;
            return "verbose";
        L15:
            if (this != Info) goto L17;
            return "info";
        L17:
            return "";
        }

        public Level(String r1, int r10) {
            super(r1, r10);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$LevelAdapter;", "Lcom/bytedance/android/annie/bridge/method/util/EnumJsonAdapter;", "Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$Level;", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class LevelAdapter extends EnumJsonAdapter<Level> {
        public LevelAdapter() {
        }

        public final Object read(JsonReader r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            if (r10.peek() != JsonToken.NULL) goto L7;
            r10.nextNull();
            return null;
        L7:
            String r11 = r10.nextString();
            Level.Companion.getClass();
            Intrinsics.checkNotNullParameter(r11, "level");
            if (StringsKt.equals(r11, IHostStyleUIDepend.TOAST_TYPE_ERROR, true) == false) goto L11;
            return Level.Error;
        L11:
            if (StringsKt.equals(r11, IHostStyleUIDepend.TOAST_TYPE_WARN, true) == false) goto L14;
            return Level.Warn;
        L14:
            if (StringsKt.equals(r11, "debug", true) == false) goto L17;
            return Level.Debug;
        L17:
            if (StringsKt.equals(r11, "verbose", true) == false) goto L20;
            return Level.Verbose;
        L20:
            if (StringsKt.equals(r11, "info", true) == true) goto L22;
            return null;
        L22:
            return Level.Info;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/ReportALogParamModel$a;", "", "", "file", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setFile", "(Ljava/lang/String;)V", "", "line", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setLine", "(Ljava/lang/Integer;)V", "function", "b", "setFunction", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("file")
        private String file;

        @SerializedName("function")
        private String function;

        @SerializedName("line")
        private Integer line;

        public a() {
        }

        public final String a() {
            return this.file;
        }

        public final String b() {
            return this.function;
        }

        public final Integer c() {
            return this.line;
        }
    }

    public ReportALogParamModel() {
    }

    public final a a() {
        return this.codePosition;
    }

    public final Level b() {
        return this.level;
    }

    public final String c() {
        return this.message;
    }

    public final String d() {
        return this.tag;
    }
}

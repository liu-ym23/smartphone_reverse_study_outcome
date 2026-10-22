package com.larus.voicecall.impl.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class RealtimeServerErrorDetail {
    public static final a f = null;
    public final int a;
    public final Presentation b;
    public final String c;
    public final Boolean d;
    public final String e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/voicecall/impl/utils/RealtimeServerErrorDetail$Presentation;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "TOAST", "ALERT", "SILENT", "HANGUP", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Presentation extends Enum<Presentation> {
        public static final Presentation ALERT = null;
        public static final Presentation HANGUP = null;
        public static final Presentation SILENT = null;
        public static final Presentation TOAST = null;
        public static final /* synthetic */ Presentation[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Presentation> getEntries() {
            return b;
        }

        static {
            Presentation r0 = new Presentation("TOAST", 0);
            TOAST = r0;
            Presentation r1 = new Presentation("ALERT", 1);
            ALERT = r1;
            Presentation r3 = new Presentation("SILENT", 2);
            SILENT = r3;
            Presentation r5 = new Presentation("HANGUP", 3);
            HANGUP = r5;
            Presentation[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static Presentation[] values() {
            return (Presentation[]) a.clone();
        }

        public static Presentation valueOf(String r1) {
            return (Presentation) r27.a.a(Presentation.class, r1);
        }

        public Presentation(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }

        public static RealtimeServerErrorDetail a(String r10) {
            boolean r0 = false;
            if (r10 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            Object r3 = null;
            if (r2 == false) goto L116;
            return null;
        L116:
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L104
            JsonElement r11 = new JsonParser().parse(r10);     // Catch: Throwable -> L104
            if (r11.isJsonObject() == true) goto L15;
            return null;
        L15:
            JsonObject r12 = r11.getAsJsonObject();     // Catch: Throwable -> L104
            JsonElement r5 = r12.get(LynxResourceModule.CODE_KEY);     // Catch: Throwable -> L104
            if (r5 != null) goto L18;
        L37:
            int r6 = 0;
        L38:
            JsonElement r7 = r12.get("retry");     // Catch: Throwable -> L104
            if (r7 != null) goto L41;
        L51:
            Boolean r8 = null;
        L52:
            JsonElement r9 = r12.get("type");     // Catch: Throwable -> L104
            if (r9 != null) goto L55;
        L65:
            String r13 = null;
        L66:
            if (r13 != null) goto L114;
            r13 = NameKeys.UnloadStrategy_No_Strategy;
        L114:
            Object r14 = Result.constructor-impl(Presentation.valueOf(r13.toUpperCase(Locale.ROOT)));     // Catch: Throwable -> L70
        L72:
            Presentation r15 = Presentation.SILENT;     // Catch: Throwable -> L104
            if (Result.isFailure-impl(r14) == false) goto L75;
            r14 = r15;
        L75:
            Presentation r16 = (Presentation) r14;     // Catch: Throwable -> L104
            JsonElement r17 = r12.get("toastText");     // Catch: Throwable -> L104
            if (r17 != null) goto L78;
        L88:
            String r18 = null;
        L89:
            JsonElement r19 = r12.get("sceneHint");     // Catch: Throwable -> L104
            if (r19 != null) goto L92;
        L101:
            String r20 = null;
        L102:
            Object r110 = Result.constructor-impl(new RealtimeServerErrorDetail(r6, r16, r18, r8, r20));     // Catch: Throwable -> L104
        L107:
            if (Result.isFailure-impl(r110) == true) goto L111;
            r3 = r110;
        L111:
            return (RealtimeServerErrorDetail) r3;
        L92:
            if (r19.isJsonPrimitive() == true) goto L94;
        L96:
            if (r0 == true) goto L99;
            r19 = null;
        L99:
            if (r19 == null) goto L101;
            r20 = r19.getAsString();     // Catch: Throwable -> L104
            goto L102
        L94:
            if (r19.getAsJsonPrimitive().isString() == false) goto L96;
            r0 = true;
            goto L96
        L78:
            if (r17.isJsonPrimitive() == true) goto L80;
        L82:
            boolean r21 = false;
        L83:
            if (r21 == true) goto L86;
            r17 = null;
        L86:
            if (r17 == null) goto L88;
            r18 = r17.getAsString();     // Catch: Throwable -> L104
            goto L89
        L80:
            if (r17.getAsJsonPrimitive().isString() == false) goto L82;
            r21 = true;
            goto L83
        L70:
            th = move-exception;
            Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L104
            r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L104
            goto L72
        L55:
            if (r9.isJsonPrimitive() == true) goto L57;
        L59:
            boolean r23 = false;
        L60:
            if (r23 == true) goto L63;
            r9 = null;
        L63:
            if (r9 == null) goto L65;
            r13 = r9.getAsString();     // Catch: Throwable -> L104
            goto L66
        L57:
            if (r9.getAsJsonPrimitive().isString() == false) goto L59;
            r23 = true;
            goto L60
        L41:
            if (r7.isJsonPrimitive() == true) goto L43;
        L45:
            boolean r24 = false;
        L46:
            if (r24 == true) goto L49;
            r7 = null;
        L49:
            if (r7 == null) goto L51;
            r8 = Boolean.valueOf(r7.getAsBoolean());     // Catch: Throwable -> L104
            goto L52
        L43:
            if (r7.getAsJsonPrimitive().isBoolean() == false) goto L45;
            r24 = true;
            goto L46
        L18:
            if (r5.isJsonPrimitive() == true) goto L20;
        L22:
            boolean r25 = false;
        L23:
            if (r25 == true) goto L26;
            r5 = null;
        L26:
            if (r5 == null) goto L37;
            Object r26 = Result.constructor-impl(Integer.valueOf(r5.getAsInt()));     // Catch: Throwable -> L29
        L32:
            if (Result.isFailure-impl(r26) == false) goto L34;
            r26 = null;
        L34:
            Integer r27 = (Integer) r26;     // Catch: Throwable -> L104
            if (r27 == null) goto L37;
            r6 = r27.intValue();     // Catch: Throwable -> L104
        L29:
            th = move-exception;
            Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L104
            r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L104
            goto L32
        L20:
            if (r5.getAsJsonPrimitive().isNumber() == false) goto L22;
            r25 = true;
        L104:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            r110 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L107
        L5:
            if (StringsKt.isBlank(r10) == true) goto L8;
            r2 = false;
            goto L9
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RealtimeServerErrorDetail) == true) goto L8;
        return false;
    L8:
        RealtimeServerErrorDetail r6 = (RealtimeServerErrorDetail) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Boolean r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.e;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "RealtimeServerErrorDetail(code=" + this.a + ", presentation=" + this.b + ", displayText=" + this.c + ", retry=" + this.d + ", sceneHint=" + this.e + ')';
    }

    static {
        f = new a();
    }

    public RealtimeServerErrorDetail(int r2, Presentation r3, String r4, Boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "presentation");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}

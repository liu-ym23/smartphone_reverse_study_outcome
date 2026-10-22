package com.larus.bmhome.music.protocol;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.larus.im.internal.delegate.c0;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/music/protocol/MusicCreationTemplate;", "", "<init>", "()V", "lyric", "", "getLyric", "()Ljava/lang/String;", "templateOptionConfString", "getTemplateOptionConfString", "setTemplateOptionConfString", "(Ljava/lang/String;)V", "templateOptionConf", "Lcom/larus/bmhome/instruction/core/model/music/TemplateOptionConf;", "Lcom/larus/bmhome/music/protocol/TemplateOptionConf;", "getTemplateOptionConf", "()Lcom/larus/bmhome/instruction/core/model/music/TemplateOptionConf;", "prompt", "getPrompt", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName("lyric")
    private final String lyric;

    @SerializedName("prompt")
    private final String prompt;

    @SerializedName("option_value_conf")
    private String templateOptionConfString;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<bq8.d> {
        public a() {
        }
    }

    public final bq8.d c() {
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L24
        zd9.h r3 = zd9.h.a;     // Catch: Throwable -> L24
        String r4 = this.templateOptionConfString;     // Catch: Throwable -> L24
        if (r4 != null) goto L6;
    L9:
        boolean r5 = true;
    L10:
        if (r5 == false) goto L32;
    L11:
        Object r6 = null;
    L22:
        Object r0 = Result.constructor-impl((bq8.d) r6);     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r0) == true) goto L31;
        r1 = r0;
    L31:
        return (bq8.d) r1;
    L32:
        r3.getClass();     // Catch: Throwable -> L14
        r6 = Result.constructor-impl(zd9.h.b.fromJson(r4, new a().getType()));     // Catch: Throwable -> L14
    L16:
        Throwable r7 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L24
        if (r7 == null) goto L20;
        c0 r8 = c0.b;     // Catch: Throwable -> L24
        StringBuilder r9 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r7, "<this>");     // Catch: Throwable -> L24
        r9.append(ExceptionsKt.stackTraceToString(r7));     // Catch: Throwable -> L24
        r8.e("GsonHolder", r9.toString());     // Catch: Throwable -> L24
    L20:
        if (Result.isFailure-impl(r6) == false) goto L22;
    L14:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L24
        r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L24
        goto L16
    L6:
        if (StringsKt.isBlank(r4) == true) goto L9;
        r5 = false;
    L24:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }

    public e() {
        this.templateOptionConfString = "";
    }

    public final String a() {
        return this.lyric;
    }

    public final String b() {
        return this.prompt;
    }

    public final String d() {
        return this.templateOptionConfString;
    }
}

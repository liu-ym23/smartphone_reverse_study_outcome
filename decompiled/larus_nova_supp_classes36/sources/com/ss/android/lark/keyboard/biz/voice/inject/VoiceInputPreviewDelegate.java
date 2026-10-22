package com.ss.android.lark.keyboard.biz.voice.inject;

import android.text.Editable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class VoiceInputPreviewDelegate {
    public final com.ss.android.lark.keyboard.b a;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b b;
    public final Function0<Unit> c;
    public final Function0<Boolean> d;
    public final CoroutineScope e;
    public final Lazy f;
    public final Lazy g;
    public Job h;
    public boolean i;
    public PreviewOriginMode j;
    public boolean k;
    public String l;
    public boolean m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/keyboard/biz/voice/inject/VoiceInputPreviewDelegate$PreviewOriginMode;", "", "<init>", "(Ljava/lang/String;I)V", "INPUT_UNFOCUSED", "VOICE_MODE", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum PreviewOriginMode extends Enum<PreviewOriginMode> {
        public static final PreviewOriginMode INPUT_UNFOCUSED = null;
        public static final PreviewOriginMode VOICE_MODE = null;
        public static final /* synthetic */ PreviewOriginMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PreviewOriginMode> getEntries() {
            return b;
        }

        static {
            PreviewOriginMode r0 = new PreviewOriginMode("INPUT_UNFOCUSED", 0);
            INPUT_UNFOCUSED = r0;
            PreviewOriginMode r1 = new PreviewOriginMode("VOICE_MODE", 1);
            VOICE_MODE = r1;
            PreviewOriginMode[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static PreviewOriginMode[] values() {
            return (PreviewOriginMode[]) a.clone();
        }

        public static PreviewOriginMode valueOf(String r1) {
            return (PreviewOriginMode) r27.a.a(PreviewOriginMode.class, r1);
        }

        public PreviewOriginMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public final fya.a.d b() {
        return (fya.a.d) this.f.getValue();
    }

    public final String c() {
        Editable r0 = this.a.L().c().getText();
        if (r0 == null) goto L8;
        String r1 = r0.toString();
        if (r1 == null) goto L8;
        String r2 = StringsKt.replace$default(r1, " ", "", false, 4, null);
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    public final void a(boolean r5) {
        if (this.h != null) goto L12;
        fya.a.d r0 = b();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L12;
        return;
    L7:
        if (r0.isLoading() != true) goto L9;
        r1 = true;
    L12:
        Job r2 = this.h;
        if (r2 == null) goto L15;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L15:
        this.h = null;
        if (r5 == false) goto L32;
        fya.a.d r6 = b();
        if (r6 != null) goto L20;
    L22:
        boolean r7 = false;
    L23:
        if (r7 == false) goto L35;
        this.m = true;
        fya.a.d r8 = b();     // Catch: Throwable -> L29
        if (r8 == null) goto L28;
        r8.b(this.a.L().c());     // Catch: Throwable -> L29
    L28:
        this.m = false;
        return;
    L29:
        th = move-exception;
        this.m = false;
        throw th;
    L35:
        return;
    L20:
        if (r6.isLoading() != true) goto L22;
        r7 = true;
        goto L23
    }

    public VoiceInputPreviewDelegate(com.ss.android.lark.keyboard.b r2, com.ss.android.lark.biz.im.api.extension.chat_window.b r3, Function0<? extends fya.a.d> r4, Function0<Unit> r5, Function0<Boolean> r6) {
        Intrinsics.checkNotNullParameter(r2, "keyboard");
        Intrinsics.checkNotNullParameter(r3, "keyboardPluginContext");
        Intrinsics.checkNotNullParameter(r4, "previewAbilityProvider");
        Intrinsics.checkNotNullParameter(r5, "restoreVoiceMode");
        Intrinsics.checkNotNullParameter(r6, "isDestroyed");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.f = LazyKt.lazy(r4);
        this.g = LazyKt.lazy(VoiceInputPreviewDelegate$voiceTextPostProcessService$2.INSTANCE);
        this.j = PreviewOriginMode.INPUT_UNFOCUSED;
        this.l = "";
    }
}

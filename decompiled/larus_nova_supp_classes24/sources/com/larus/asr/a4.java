package com.larus.asr;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.asr.config.ChatSpeakerStatus;
import com.larus.asr.config.builder.ChatSpeakerElementKey;
import com.larus.asr.config.builder.ChatSpeakerScene;
import com.larus.asr.view.ChatSpeaker;
import com.larus.asr.view.ChatSpeaker$c;
import com.larus.common_ui.widget.input.AudioVisualizerEx;
import com.larus.common_ui.widget.input.AudioVisualizerOpt;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import v19.i5;
import y48.b0;
import y48.c0;
import y48.i;
import y48.q;
import y48.t;
import y48.w;
import y48.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a4 {
    public final Function0<maa.b> a;
    public final Function1<Pair<Float, Float>, Boolean> b;
    public final Function1<Boolean, Unit> c;
    public boolean d;
    public final c e;
    public final b f;

    public static final class a {
    }

    public static final class b implements y48.m {
        public y48.l a;
        public Boolean b;
        public Boolean c;
        public final /* synthetic */ a4 d;

        public final void j() {
            this.a = null;
        }

        @Override // y48.m, y48.n
        public final void detach() {
            j();
        }

        public b(a4 r1) {
            this.d = r1;
        }

        @Override // y48.n
        public final void e(y r7) {
            Intrinsics.checkNotNullParameter(r7, "state");
            y48.l r0 = this.a;
            FrameLayout.LayoutParams r1 = null;
            if (r0 == null) goto L5;
            View r2 = r0.a(ChatSpeakerElementKey.Visualizer);
        L7:
            if ((r2 instanceof ViewGroup) == false) goto L9;
            ViewGroup r3 = (ViewGroup) r2;
        L10:
            int r4 = 0;
            if (r7.b != ChatSpeakerStatus.Cancel) goto L13;
            boolean r5 = true;
        L15:
            if (Intrinsics.areEqual(this.c, Boolean.valueOf(r5)) == true) goto L20;
            this.c = Boolean.valueOf(r5);
            maa.b r6 = (maa.b) this.d.a.invoke();
            if (r6 == null) goto L20;
            r6.r0(r3, r5);
        L20:
            if (Intrinsics.areEqual(this.b, Boolean.valueOf(r7.a)) == true) goto L34;
            this.b = Boolean.valueOf(r7.a);
            this.d.c.invoke(Boolean.valueOf(r7.a));
            if (r3 == null) goto L24;
            View r8 = r3.getChildAt(0);
        L26:
            if ((r8 instanceof iga.a) == false) goto L28;
            iga.a r9 = (iga.a) r8;
        L29:
            if (r9 == null) goto L31;
            r9.a();
        L31:
            maa.b r10 = (maa.b) this.d.a.invoke();
            if (r10 == null) goto L34;
            r10.l(r7.a);
            goto L34
        L28:
            r9 = null;
            goto L29
        L24:
            r8 = null;
        L34:
            if (r3 == null) goto L36;
            View r11 = r3.getChildAt(0);
        L38:
            if ((r11 instanceof AudioVisualizerOpt) == false) goto L40;
            AudioVisualizerOpt r12 = (AudioVisualizerOpt) r11;
        L41:
            if (r12 == null) goto L43;
            ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        L45:
            if ((r13 instanceof FrameLayout.LayoutParams) == false) goto L47;
            r1 = (FrameLayout.LayoutParams) r13;
        L47:
            if (r12 == null) goto L58;
            if (r1 != null) goto L50;
            return;
        L50:
            if (this.d.d == false) goto L52;
            int r14 = i5.b();
        L53:
            r1.leftMargin = r14;
            if (this.d.d == false) goto L56;
            r4 = i5.b();
        L56:
            r1.rightMargin = r4;
            r12.setLayoutParams(r1);
            return;
        L52:
            r14 = 0;
            goto L53
        L58:
            return;
        L43:
            r13 = null;
            goto L45
        L40:
            r12 = null;
            goto L41
        L36:
            r11 = null;
            goto L38
        L13:
            r5 = false;
            goto L15
        L9:
            r3 = null;
            goto L10
        L5:
            r2 = null;
            goto L7
        }

        public final void h(ChatSpeaker$c r2) {
            Intrinsics.checkNotNullParameter(r2, "host");
            this.a = r2;
            this.b = null;
            this.c = null;
        }

        @Override // y48.m, y48.n
        public final void a(ChatSpeaker$c r2, y r3) {
            Intrinsics.checkNotNullParameter(r2, "host");
            Intrinsics.checkNotNullParameter(r3, "state");
            i(r2, r3);
        }

        public final void i(ChatSpeaker$c r2, y r3) {
            Intrinsics.checkNotNullParameter(r2, "host");
            Intrinsics.checkNotNullParameter(r3, "state");
            h(r2);
        }
    }

    public static final class c implements c0 {
        public final /* synthetic */ a4 a;

        @Override // y48.n
        public final void detach() {
        }

        public c(a4 r1) {
            this.a = r1;
        }

        @Override // y48.c0
        public final void b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
        }

        @Override // y48.n
        public final void e(y r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            Intrinsics.checkNotNullParameter(r2, "state");
        }

        @Override // y48.n
        public final void a(ChatSpeaker$c r3, y r4) {
            Intrinsics.checkNotNullParameter(r3, "host");
            Intrinsics.checkNotNullParameter(r4, "state");
            Intrinsics.checkNotNullParameter(r3, "host");
            Intrinsics.checkNotNullParameter(r4, "state");
        }

        @Override // y48.c0
        public final View c(Context r2, FrameLayout r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "parent");
            IObricChatUIService r4 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
            if (r4 == null) goto L8;
            View r5 = r4.v(r2);
            if (r5 == null) goto L8;
            return r5;
        L8:
            if (com.larus.platform.service.z2.a.getStreamAsrConfig().a() == false) goto L11;
            return new AudioVisualizerOpt(r2);
        L11:
            return new AudioVisualizerEx(r2);
        }

        @Override // y48.c0
        public final void f(LifecycleCoroutineScope r2, View r3) {
            Intrinsics.checkNotNullParameter(r2, "scope");
            Intrinsics.checkNotNullParameter(r3, "view");
        }

        @Override // y48.c0
        public final void g(View r2, FrameLayout r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "parent");
            maa.b r4 = (maa.b) this.a.a.invoke();
            if (r4 == null) goto L6;
            r4.J0(r3);
            return;
        }

        @Override // y48.c0
        public final boolean d(CoroutineScope r2, View r3, byte[] r4) {
            Intrinsics.checkNotNullParameter(r2, "scope");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "data");
            if ((r3 instanceof iga.a) == false) goto L5;
            iga.a r5 = (iga.a) r3;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            r5.setAudioData(r4);
            return true;
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r8v14, types: [com.larus.asr.o3, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v16, types: [com.larus.asr.r3, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v18, types: [com.larus.asr.s3, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v20, types: [com.larus.asr.t3, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v22, types: [com.larus.asr.u3, java.lang.Object] */
    public final y48.v a(y48.v r8) {
        Intrinsics.checkNotNullParameter(r8, "baseSpec");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[SpeakerBuilder] buildSpec baseScene=");
        r1.append(r8.a);
        r1.append(" resourceCallbackPresent=");
        if (this.a.invoke() == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r1.append(" chatWindowStyle=");
        r1.append(this.d);
        r0.i("OChatSpeakerSpecController", r1.toString());
        int r3 = y48.f.h;
        y48.f r4 = y48.f.a.a();
        Intrinsics.checkNotNullParameter(r8, "spec");
        r4.a = r8.a;
        r4.b = r8.b;
        r4.c = r8.c;
        r4.d = MapsKt.toMutableMap(r8.d.a);
        r4.e = true;
        r4.getClass();
        r4.f = true;
        r4.g = true;
        ChatSpeakerScene r9 = ChatSpeakerScene.O;
        Intrinsics.checkNotNullParameter(r9, "scene");
        r4.a = r9;
        r4.c = y48.d.a(r4.c, false, false, false, 13);
        maa.b r10 = (maa.b) this.a.invoke();
        if (r10 != null) goto L9;
    L11:
        boolean r11 = false;
    L12:
        y48.d r12 = y48.d.a(r4.c, false, r11, false, 11);
        r4.c = r12;
        r4.c = y48.d.a(r12, false, false, true, 7);
        ?? r13 = new o3(this);
        Intrinsics.checkNotNullParameter(r13, "configure");
        ChatSpeakerElementKey r5 = ChatSpeakerElementKey.Tips;
        Map<ChatSpeakerElementKey, i> r6 = r4.d;
        i r7 = r6.get(r5);
        if (r7 != null) goto L15;
        int r14 = i.j;
        r7 = i.a.a(r5);
    L15:
        Intrinsics.checkNotNullParameter(r7, "source");
        w r15 = new w(r7);
        r13.invoke(r15);
        r6.put(r5, r15.a());
        ?? r16 = new r3(this);
        Intrinsics.checkNotNullParameter(r16, "configure");
        ChatSpeakerElementKey r17 = ChatSpeakerElementKey.Shadow;
        Map<ChatSpeakerElementKey, i> r19 = r4.d;
        i r20 = r19.get(r17);
        if (r20 != null) goto L18;
        int r21 = i.j;
        r20 = i.a.a(r17);
    L18:
        Intrinsics.checkNotNullParameter(r20, "source");
        t r22 = new t(r20);
        r16.invoke(r22);
        r19.put(r17, r22.a());
        ?? r23 = new s3(this);
        Intrinsics.checkNotNullParameter(r23, "configure");
        ChatSpeakerElementKey r24 = ChatSpeakerElementKey.Visualizer;
        Map<ChatSpeakerElementKey, i> r25 = r4.d;
        i r26 = r25.get(r24);
        if (r26 != null) goto L21;
        int r27 = i.j;
        r26 = i.a.a(r24);
    L21:
        Intrinsics.checkNotNullParameter(r26, "source");
        b0 r29 = new b0(r26);
        r23.invoke(r29);
        r25.put(r24, r29.a());
        ?? r30 = new t3();
        Intrinsics.checkNotNullParameter(r30, "configure");
        ChatSpeakerElementKey r31 = ChatSpeakerElementKey.FullShadow;
        Map<ChatSpeakerElementKey, i> r32 = r4.d;
        i r33 = r32.get(r31);
        if (r33 != null) goto L24;
        int r34 = i.j;
        r33 = i.a.a(r31);
    L24:
        Intrinsics.checkNotNullParameter(r33, "source");
        q r35 = new q(r33);
        r30.invoke(r35);
        r32.put(r31, r35.a());
        ?? r36 = new u3(this);
        Intrinsics.checkNotNullParameter(r36, "configure");
        ChatSpeakerElementKey r37 = ChatSpeakerElementKey.CancelArea;
        Map<ChatSpeakerElementKey, i> r38 = r4.d;
        i r39 = r38.get(r37);
        if (r39 != null) goto L27;
        int r40 = i.j;
        r39 = i.a.a(r37);
    L27:
        Intrinsics.checkNotNullParameter(r39, "source");
        y48.b r41 = new y48.b(r39);
        r36.invoke(r41);
        r38.put(r37, r41.a());
        return r4.a();
    L9:
        if (r10.B0() != true) goto L11;
        r11 = true;
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    public final void b(ChatSpeaker r4, boolean r5) {
        this.d = r5;
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[SpeakerBuilder] updateChatWindowStyle enabled=");
        r1.append(r5);
        r1.append(" speaker=");
        if (r4 == null) goto L5;
        Integer r6 = Integer.valueOf(r4.hashCode());
    L6:
        r1.append(r6);
        r0.i("OChatSpeakerSpecController", r1.toString());
        if (r4 == null) goto L10;
        r4.L7();
        return;
    L10:
        return;
    L5:
        r6 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a4(Function0<? extends maa.b> r2, Function1<? super Pair<Float, Float>, Boolean> r3, Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "resourceCallbackProvider");
        Intrinsics.checkNotNullParameter(r3, "shouldCancel");
        Intrinsics.checkNotNullParameter(r4, "visibilityCallback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = new c(this);
        this.f = new b(this);
    }
}

package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent;
import com.ss.android.lark.keyboard.plugin.tool.voice.AudioRecordMutexController;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImmersiveVoiceInputComponent implements IKeyboardContent {
    public static final a a = null;
    public static final ArrayList<g0> b = null;

    public static final class a implements IKeyboardContent.a {

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceInputComponent$a$a, reason: collision with other inner class name */
        public static final class C0161a implements com.ss.android.lark.audio.voiceinput.h {
            public com.ss.android.lark.keyboard.plugin.tool.voice.b a;
            public final /* synthetic */ Context b;
            public final /* synthetic */ boolean c;
            public final /* synthetic */ ImmersiveVoiceViewModel d;

            public final void a() {
                com.ss.android.lark.keyboard.plugin.tool.voice.b r0 = this.a;
                if (r0 == null) goto L5;
                Lazy<AudioRecordMutexController> r1 = AudioRecordMutexController.d;
                AudioRecordMutexController r2 = AudioRecordMutexController.a.a();
                r2.getClass();
                Intrinsics.checkNotNullParameter(r0, "listener");
                r2.b.remove(r0);
            L5:
                this.a = null;
                Lazy<AudioRecordMutexController> r3 = AudioRecordMutexController.d;
                AudioRecordMutexController.a(AudioRecordMutexController.a.a());
            }

            public final boolean b() {
                Context r0 = this.b;
                com.ss.android.lark.keyboard.plugin.tool.voice.b r1 = this.a;
                if (r1 == null) goto L5;
                Lazy<AudioRecordMutexController> r3 = AudioRecordMutexController.d;
                AudioRecordMutexController r4 = AudioRecordMutexController.a.a();
                r4.getClass();
                Intrinsics.checkNotNullParameter(r1, "listener");
                r4.b.remove(r1);
            L5:
                this.a = null;
                Lazy<AudioRecordMutexController> r2 = AudioRecordMutexController.d;
                AudioRecordMutexController r5 = AudioRecordMutexController.a.a();
                final boolean r6 = this.c;
                final ImmersiveVoiceViewModel r7 = this.d;
                Function0<Unit> r8 = new ImmersiveVoiceInputComponent$Key$initViewModelWithKeyIfNeed$1$1$addInterceptionListener$1(r6, r7);
                r5.getClass();
                Intrinsics.checkNotNullParameter(r0, "context");
                com.ss.android.lark.keyboard.plugin.tool.voice.b r9 = new com.ss.android.lark.keyboard.plugin.tool.voice.b(r8, r0, r5);
                this.a = r9;
                AudioRecordMutexController r10 = AudioRecordMutexController.a.a();
                r10.getClass();
                Intrinsics.checkNotNullParameter(r9, "listener");
                r10.b.add(r9);
                return AudioRecordMutexController.b(AudioRecordMutexController.a.a(), this.b);
            }

            public C0161a(Context r1, boolean r2, ImmersiveVoiceViewModel r3) {
                this.b = r1;
                this.c = r2;
                this.d = r3;
            }
        }

        @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent.a
        public final String getTag() {
            return "ImmersiveVoiceKeyboardKey";
        }

        public a() {
        }

        public static ImmersiveVoiceViewModel a(boolean r4, x r5, w r6, Context r7) {
            Intrinsics.checkNotNullParameter(r5, "voiceInputDependency");
            Intrinsics.checkNotNullParameter(r6, "voiceInputConfig");
            Intrinsics.checkNotNullParameter(r7, "context");
            String r0 = "androidx.lifecycle.ViewModelProvider.DefaultKey.SimpleImmersiveVoiceView:" + ImmersiveVoiceViewModel.Companion.getClass().getCanonicalName();
            if (r4 == false) goto L5;
            Fragment r3 = r5.e;
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
            ImmersiveVoiceViewModel r1 = (ImmersiveVoiceViewModel) new ViewModelProvider(r3).get(r0, ImmersiveVoiceViewModel.class);
        L7:
            if (r1.isNeedInit() == false) goto L14;
            r1.setEnableVoiceInputSdk(r6.a);
            r1.setAsrEnable(r6.d.a());
            r1.setAsrNerEnable(r6.b);
            if (r6.d.b != VoiceInputScene.SecretChat) goto L12;
            boolean r2 = true;
        L13:
            r1.setSupportPartialUpload(!r2);
            r1.setAutoSendOnRecognizeFinish(r6.i);
            r1.setOnlyAsrRecognizingTipsProvider(r6.j);
            r1.setHidePopupOnReleaseKeepSession(r6.k);
            r1.init(r5, r6, new C0161a(r7, r4, r1), r6.f);
            goto L14
        L12:
            r2 = false;
        L14:
            return r1;
        L5:
            Fragment r8 = r5.e;
            Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
            r1 = (ImmersiveVoiceViewModel) new ViewModelProvider(r8).get(ImmersiveVoiceViewModel.class);
            goto L7
        }
    }

    public static final class b {
        public final View a;
        public final Function0<Unit> b;
        public final long c;
        public final float d;
        public float e;
        public float f;
        public long g;
        public final a h;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Function0<Unit> r0 = this.a.b;     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.invoke();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public final void a() {
            this.a.removeCallbacks(this.h);
        }

        public final void b(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            this.e = r2.getX();
            this.f = r2.getY();
        }

        public final void c(MotionEvent r5) {
            Intrinsics.checkNotNullParameter(r5, "event");
            this.a.postDelayed(this.h, this.c);
            this.e = r5.getX();
            this.f = r5.getY();
            this.g = System.currentTimeMillis();
        }

        public final void d(MotionEvent r5) {
            Intrinsics.checkNotNullParameter(r5, "event");
            float r0 = r5.getX() - this.e;
            float r6 = r5.getY() - this.f;
            if (Math.abs(r0) < this.d) goto L5;
        L9:
            boolean r7 = false;
        L10:
            if (r7 == false) goto L12;
            this.a.performClick();
        L12:
            a();
            return;
        L5:
            if (Math.abs(r6) >= this.d) goto L9;
            if ((System.currentTimeMillis() - this.g) >= this.c) goto L9;
            r7 = true;
            goto L10
        }

        public b(View r2, Function0<Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "host");
            this.a = r2;
            this.b = r3;
            this.c = 300;
            this.d = 10.0f;
            this.h = new a(this);
        }
    }

    public ImmersiveVoiceInputComponent() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void c(int r1) {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final IKeyboardContent.a getKey() {
        return null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onHide() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onShow() {
    }

    static {
        a = new a();
        b = new ArrayList();
    }

    private final Activity getContext() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final IKeyboardContent.ViewInitStrategy a() {
        return IKeyboardContent.ViewInitStrategy.Lazy;
    }

    public final int e() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onCreate() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onDestroy() {
        throw null;
    }

    public static final /* synthetic */ Activity d(ImmersiveVoiceInputComponent r0) {
        return r0.getContext();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final View b(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceInputComponent$getTouchListener$2] */
    public static ImmersiveVoiceInputComponent$getTouchListener$2 f(final ImmersiveVoiceInputComponent r2, final Function0 r3) {
        Intrinsics.checkNotNullParameter(ImmersiveVoiceInputComponent$getTouchListener$1.INSTANCE, "longPressInterceptor");
        return new ImmersiveVoiceInputComponent$getTouchListener$2(r2, r3);
    }

    public final void g(int r3, boolean r4) {
        com.ss.android.lark.c.a(null);
        PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        if (r4 == false) goto L7;
        throw null;
    L7:
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onActivityResult(int r1, int r2, Intent r3) {
        if (r1 == 10000) goto L6;
        return;
    L6:
        throw null;
    }
}

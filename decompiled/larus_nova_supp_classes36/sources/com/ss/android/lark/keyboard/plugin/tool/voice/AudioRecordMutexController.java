package com.ss.android.lark.keyboard.plugin.tool.voice;

import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.ss.android.lark.im.base.browser.IImBrowserService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.media.MediaMutex;
import com.ss.android.lark.media.MediaType;
import com.ss.android.lark.media.Scene;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AudioRecordMutexController {
    public static final Lazy<AudioRecordMutexController> d = null;
    public c a;
    public final CopyOnWriteArraySet<b> b;
    public final d c;

    public static final class a {
        @JvmStatic
        public static AudioRecordMutexController a() {
            return (AudioRecordMutexController) AudioRecordMutexController.d.getValue();
        }
    }

    public interface b {
        void a(Scene r1, MediaType r2);
    }

    public interface c {

        public static final class a implements c {
            public final MediaMutex.LockError a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Error(lockError=" + this.a + ')';
            }

            public a(MediaMutex.LockError r2) {
                Intrinsics.checkNotNullParameter(r2, "lockError");
                this.a = r2;
            }
        }

        public static final class b implements c {
            public final Scene a;
            public final MediaType b;
            public final String c;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof b) == true) goto L8;
                return false;
            L8:
                b r6 = (b) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (this.b == r6.b) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
                String r1 = this.c;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public final String toString() {
                return "Interrupted(byScene=" + this.a + ", type=" + this.b + ", interruptMsg=" + this.c + ')';
            }

            public final MediaType getType() {
                return this.b;
            }

            public b(Scene r2, MediaType r3) {
                Intrinsics.checkNotNullParameter(r2, "byScene");
                Intrinsics.checkNotNullParameter(r3, "type");
                this.a = r2;
                this.b = r3;
                this.c = "";
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.AudioRecordMutexController$c$c, reason: collision with other inner class name */
        public static final class C0156c implements c {
            public static final C0156c a = null;

            static {
                a = new C0156c();
            }

            public C0156c() {
            }
        }
    }

    public static final class d implements com.ss.android.lark.media.a {
        public final /* synthetic */ AudioRecordMutexController a;

        @Override // com.ss.android.lark.media.a
        public final void onSuccess() {
            AudioRecordMutexController r0 = this.a;
            r0.a = c.C0156c.a;
        }

        public d(AudioRecordMutexController r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.media.a
        public final void a(MediaMutex.LockError r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            Log.w("AudioRecordMutexController", "media is occupied, scene:" + r3.getOccupiedScene());
            this.a.a = new c.a(r3);
        }

        @Override // com.ss.android.lark.media.a
        public final void b(Scene r3, MediaType r4) {
            Intrinsics.checkNotNullParameter(r3, "byScene");
            Intrinsics.checkNotNullParameter(r4, "type");
            Log.i("AudioRecordMutexController", "Interrupted byScene:" + r3 + ",type:" + r4 + ",interruptMsg:");
            this.a.a = new c.b(r3, r4);
            Iterator<b> r0 = this.a.b.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().a(r3, r4);
            goto L4
        }

        @Override // com.ss.android.lark.media.a
        public final void c(Scene r3, MediaType r4) {
            Intrinsics.checkNotNullParameter(r3, IImBrowserService.KEY_FROM_SCENE);
            Intrinsics.checkNotNullParameter(r4, "type");
            Log.i("AudioRecordMutexController", "InterruptionEnd fromScene:" + r3 + ",type:" + r4);
        }
    }

    static {
        d = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AudioRecordMutexController$Companion$sInstance$2.INSTANCE);
    }

    public AudioRecordMutexController() {
        this.b = new CopyOnWriteArraySet();
        this.c = new d(this);
    }

    public static void a(AudioRecordMutexController r2) {
        Scene r0 = Scene.IM_Audio_Record;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "scene");
        if ((r2.a instanceof c.C0156c) == false) goto L7;
        r2.a = null;
        MediaMutex.r.n(r0, r2.c);
        return;
    }

    public static boolean b(AudioRecordMutexController r8, Context r9) {
        Scene r0 = Scene.IM_Audio_Record;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r0, "scene");
        boolean r3 = true;
        if ((r8.a instanceof c.C0156c) == false) goto L5;
        Log.i("AudioRecordMutexController", "tryOccupyResource status already Occupied");
        return true;
    L5:
        MediaMutex.r.getClass();
        Log.i("AudioRecordMutexController", "tryOccupyResource tryLock");
        MediaMutex.r.l(r0, true, r8.c, true);
        c r10 = r8.a;
        if ((r10 instanceof c.a) == false) goto L15;
        c.a r11 = (c.a) r10;
        String r1 = r11.a.getErrorMessage();
        if (r1.length() > 0) goto L11;
        r3 = false;
    L11:
        if (r3 == false) goto L13;
        new UDDialogBuilder(r9).message(r1).addActionButton(2131391777, 2131891623, null).show();
    L25:
        return false;
    L13:
        Log.w("AudioRecordMutexController", "err but no msg", r11.a);
        goto L25
    L15:
        if ((r10 instanceof c.b) == false) goto L26;
        c.b r2 = (c.b) r10;
        String r7 = r2.c;
        if (r7 != null) goto L19;
    L22:
        if (r3 == false) goto L24;
        Log.w("AudioRecordMutexController", "Interrupted but no msg,byScene:" + r10 + ".byScene,type:" + r10 + ".type");
        goto L25
    L24:
        new UDDialogBuilder(r9).message(r2.c).addActionButton(2131391777, 2131891623, null).show();
        goto L25
    L19:
        if (r7.length() == 0) goto L22;
        r3 = false;
        goto L22
    L26:
        Log.i("AudioRecordMutexController", "tryOccupyResource tryLock status:" + r10 + ",isOccupied:" + (r10 instanceof c.C0156c));
        return true;
    }
}

package com.ss.android.lark.framework.assembly.emoji_office;

import android.content.Context;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.loader.EmojiImageResource;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.reaction.loader.reaction.ReactionResource;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/framework/assembly/emoji_office/UpdateEmojiTask;", "Lcom/larksuite/framework/launch/task/AsyncLaunchTask;", "", "<init>", "()V", "execute", "", "context", "Landroid/content/Context;", "Companion", "emoji-office-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class UpdateEmojiTask extends AsyncLaunchTask<Object> {

    public static final class a {
    }

    public static final class b implements Runnable {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.i("UpdateEmojiTask", "init emoji map");     // Catch: Throwable -> L4
            qsb.b.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Context a;

        public c(Context r1) {
            this.a = r1;
        }

        public final void a() {
            Log.i("UpdateEmojiTask", "init image loader");
            Context r0 = this.a;
            AtomicBoolean r1 = qsb.b.a;
            Intrinsics.checkNotNullParameter(r0, "context");
            if (qsb.b.a.compareAndSet(false, true) == false) goto L5;
            Log.i("EmojiModule", "init");
            ImageLoader.registerLoadModelHook(r0, EmojiImageResource.class, InputStream.class, new tsb.b.a());
        L5:
            int r2 = k2c.a.a;
            Context r3 = this.a;
            Intrinsics.checkNotNullParameter(r3, "context");
            ImageLoader.registerLoadModelHook(r3, ReactionResource.class, InputStream.class, new l2c.b.a());
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d extends c0c.b {

        public static final class a implements Runnable {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                Log.i("UpdateEmojiTask", "load data");     // Catch: Throwable -> L4
                AtomicBoolean r0 = qsb.b.a;     // Catch: Throwable -> L4
                int r1 = vsb.b.a;     // Catch: Throwable -> L4
                ((rsb.b) k.a(LarkContext.getApplication(), rsb.b.class)).P4();     // Catch: Throwable -> L4
                k2c.a.a().fetchData();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public d(j r1) {
            super(r1);
        }

        public final void nf(f0c.b r3) {
            Intrinsics.checkNotNullParameter(r3, "toState");
            Scene r4 = r3.b.b;
            Log.i("UpdateEmojiTask", "onPrepared, scene: " + r4);
            if (Scene.FIRST_ONLINE != r4) goto L5;
        L8:
            CoreThreadPool.getDefault().getFixedThreadPool().execute(a.a);
            return;
        L5:
            if (Scene.FAST_ONLINE == r4) goto L8;
            if (Scene.SWITCH_ONLINE == r4) goto L8;
        }
    }

    static {
    }

    public UpdateEmojiTask() {
    }

    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Log.i("UpdateEmojiTask", "execute");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(b.a);
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new c(r3));
        h.a(new d((j) LarkContext.spiByDwarf(j.class)));
    }
}

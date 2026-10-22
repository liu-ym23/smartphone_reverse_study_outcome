package e38;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.p;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.x;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.RucketJobImpl;
import com.larksuite.rucket.job.compat.CallbackCompatRucketJob;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b<T extends Message<?, ?>> extends RucketJobImpl<T> {
    public final Disposable a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ CallbackCompatRucketJob<Message<?, ?>> a;

        public a(CallbackCompatRucketJob<Message<?, ?>> r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            x r3 = (s) r2;
            if ((r3 instanceof x) == false) goto L6;
            this.a.onSuccess((Message<?, ?>) r3.c);
            return;
        L6:
            if ((r3 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L10;
            this.a.onError(p.a(((com.bytedance.lark.rustclient.api.c) r3).c));
            return;
        L10:
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: e38.b$b, reason: collision with other inner class name */
    public static final class C0103b<T> implements Consumer {
        public final /* synthetic */ CallbackCompatRucketJob<Message<?, ?>> a;

        public C0103b(CallbackCompatRucketJob<Message<?, ?>> r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            this.a.onError(new ErrorResult(new Exception((Throwable) r4)));
        }
    }

    @Override // com.larksuite.rucket.job.RucketJobImpl, com.larksuite.rucket.job.RucketJob
    public final void cancel() {
        super.cancel();
        this.a.dispose();
    }

    public b(Command r2, Class<T> r3, l r4, CallbackCompatRucketJob<Message<?, ?>> r5) {
        Intrinsics.checkNotNullParameter(r2, "command");
        Intrinsics.checkNotNullParameter(r3, "responseClazz");
        Intrinsics.checkNotNullParameter(r4, "client");
        Intrinsics.checkNotNullParameter(r5, "consumer");
        r5.setPrevJob(this);
        this.a = r4.i(r2, ProtoAdapter.get(r3)).subscribe(new a(r5), new C0103b(r5));
    }
}

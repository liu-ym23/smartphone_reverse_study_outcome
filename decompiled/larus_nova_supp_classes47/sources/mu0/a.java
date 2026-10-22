package mu0;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.profit.format.voicechat.trace.VoiceChatTraceStep;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.t;
import java.util.concurrent.Callable;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<Upstream, Downstream> implements t {
    public final /* synthetic */ VoiceChatTraceStep a;

    /* JADX INFO: renamed from: mu0.a$a, reason: collision with other inner class name */
    public static final class CallableC0273a<V> implements Callable {
        public final /* synthetic */ a a;
        public final /* synthetic */ Single b;

        /* JADX INFO: renamed from: mu0.a$a$a, reason: collision with other inner class name */
        public static final class C0274a<T> implements Consumer {
            public final /* synthetic */ CallableC0273a a;
            public final /* synthetic */ long b;

            public C0274a(CallableC0273a r1, long r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(T r7) {
                int r0 = mu0.b.a;
                VoiceChatTraceStep r1 = this.a.a.a;
                long r2 = SystemClock.uptimeMillis() - this.b;
                JSONObject r3 = new JSONObject();
                r3.put(Constants.Keys.duration, r2);
                if (r1 == VoiceChatTraceStep.SEND_GIFT) goto L5;
                boolean r4 = true;
            L6:
                Object r5 = null;
                if (r4 == false) goto L9;
                VoiceChatTraceStep r6 = r1;
            L10:
                if (r6 != null) goto L24;
            L21:
                Handler r8 = UtilityKotlinExtentionsKt.a;
                JSONObject r9 = new JSONObject();
            L22:
                String r10 = c.a;
                c.b(r1, r3, r9, 1);
                return;
            L24:
                Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L13
                Object r13 = Result.constructor-impl(new JSONObject(GsonHelper.get().toJson(r7)));     // Catch: Throwable -> L13
            L16:
                if (Result.isFailure-impl(r13) == true) goto L19;
                r5 = r13;
            L19:
                r9 = (JSONObject) r5;
                if (r9 != null) goto L22;
            L13:
                th = move-exception;
                Result.Companion r14 = Result.Companion;
                r13 = Result.constructor-impl(ResultKt.createFailure(th));
                goto L16
            L9:
                r6 = null;
                goto L10
            L5:
                r4 = false;
                goto L6
            }
        }

        /* JADX INFO: renamed from: mu0.a$a$b */
        public static final class b<T> implements Consumer {
            public final /* synthetic */ CallableC0273a a;
            public final /* synthetic */ long b;

            public b(CallableC0273a r1, long r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r6) {
                CustomApiServerException r7 = (Throwable) r6;
                int r0 = mu0.b.a;
                VoiceChatTraceStep r1 = this.a.a.a;
                long r2 = SystemClock.uptimeMillis() - this.b;
                JSONObject r3 = new JSONObject();
                r3.put(Constants.Keys.duration, r2);
                if (r7 != null) goto L5;
            L11:
                c.c(r1, r3, null, -1, 4);
                return;
            L5:
                if ((r7 instanceof CustomApiServerException) == false) goto L10;
                CustomApiServerException r8 = r7;
                String r4 = r8.getErrorMsg();
                if (r4 != null) goto L9;
                r4 = "";
            L9:
                r3.put("error_msg", r4);
                r3.put("error_code", String.valueOf(r8.getErrorCode()));
                r3.put("log_id", r8.getXTtLogId());
                goto L11
            L10:
                r3.put("stack_trace", ExceptionsKt.stackTraceToString(r7));
                goto L11
            }
        }

        public CallableC0273a(a r1, Single r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.util.concurrent.Callable
        public final SingleSource<Object> call() {
            long r0 = SystemClock.uptimeMillis();
            int r2 = mu0.b.a;
            VoiceChatTraceStep r3 = this.a.a;
            String r4 = c.a;
            c.c(r3, new JSONObject(), null, 0, 12);
            return this.b.doOnSuccess(new C0274a(this, r0)).doOnError(new b(this, r0));
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public a(VoiceChatTraceStep r1) {
        this.a = r1;
    }

    public final SingleSource<Object> apply(Single<Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "upstream");
        return Single.defer(new CallableC0273a(this, r2));
    }
}

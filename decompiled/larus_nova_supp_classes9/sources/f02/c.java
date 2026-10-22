package f02;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.bytedance.android.live.revenue.common.c0;
import com.bytedance.android.livesdk.user.h;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ f02.a a;

    public static final class a<T> implements SingleOnSubscribe {
        public final /* synthetic */ Ref.ObjectRef a;

        public a(Ref.ObjectRef r1) {
            this.a = r1;
        }

        public final void subscribe(SingleEmitter<Boolean> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            int r0 = c0.a;     // Catch: Exception -> L5
            c0.b((File) this.a.element);     // Catch: Exception -> L5
            r2.onSuccess(Boolean.TRUE);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            r2.onError(e);
        }
    }

    public static final class b extends h<Boolean> {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void onSuccess(Object r4) {
            boolean r5 = ((Boolean) r4).booleanValue();
            Context r0 = this.a.a.getContext();
            StringBuilder r1 = new StringBuilder("本地特效目录(");
            r1.append(this.a.a.getMAssetsManager().vg());
            r1.append(")删除");
            if (r5 == false) goto L5;
            String r6 = "成功";
        L6:
            r1.append(r6);
            Toast.makeText(r0, r1.toString(), 0).show();
            return;
        L5:
            r6 = "失败";
            goto L6
        }
    }

    public c(f02.a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        File r0 = new PolarisFileWrapper(this.a.getMAssetsManager().vg());
        r4.element = r0;
        if (r0.exists() == false) goto L6;
        Single.create(new a(r4)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        return;
    }
}

package q20;

import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import com.bytedance.android.live.browser.api.SendLarkInterface;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ r20.a a;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ f a;
        public final /* synthetic */ EditText b;

        /* JADX INFO: renamed from: q20.f$a$a, reason: collision with other inner class name */
        public static final class C0264a<T> implements Consumer {
            public final /* synthetic */ DialogInterface a;

            public C0264a(DialogInterface r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                Response r3 = (Response) r2;
                f2.c("发送成功", 0);
                this.a.dismiss();
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ DialogInterface a;

            public b(DialogInterface r1) {
                this.a = r1;
            }

            public final void accept(Object r1) {
                Throwable r2 = (Throwable) r1;
                this.a.dismiss();
            }
        }

        public a(f r1, EditText r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "dialog");
            if (this.b.getText().toString().length() != 0) goto L5;
            boolean r5 = true;
        L6:
            if (r5 == false) goto L9;
            f2.c("邮箱为空", 0);
            return;
        L9:
            JSONObject r6 = new JSONObject();
            r6.put("email", this.b.getText().toString());
            r6.put("msg", this.a.a.c.toString());
            r6.put("msg_title", "线上url");
            RequestBody r7 = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r6.toString());
            Observable<Response<Object>> r8 = ((SendLarkInterface) com.bytedance.android.live.network.c.b().e(SendLarkInterface.class)).postLarkMessage("https://cloudapi.bytedance.net/faas/services/tt41066dui1tz32x31/invoke/sendMessageToUser", r7);
            if (r8 == null) goto L17;
            Observable r9 = r8.subscribeOn(Schedulers.io());
            if (r9 == null) goto L18;
            Observable r11 = r9.observeOn(AndroidSchedulers.mainThread());
            if (r11 == null) goto L19;
            r11.subscribe(new C0264a(r3), new b(r3));
            return;
        L19:
            return;
        L18:
            return;
        L17:
            return;
        L5:
            r5 = false;
            goto L6
        }
    }

    public f(r20.a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        EditText r0 = new EditText(r5.getContext());
        AlertDialog.Builder r1 = new AlertDialog.Builder(r5.getContext());
        com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.b.r3;
        if (((CharSequence) r6.getValue()).length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        r0.setText((CharSequence) r6.getValue());
    L8:
        r1.setTitle("输入邮箱前缀(yangxiaodong.06)").setView(r0).setNegativeButton("Cancel", null);
        r1.setPositiveButton("Ok", new a(this, r0));
        r1.show();
        return;
    L5:
        r2 = false;
        goto L6
    }
}

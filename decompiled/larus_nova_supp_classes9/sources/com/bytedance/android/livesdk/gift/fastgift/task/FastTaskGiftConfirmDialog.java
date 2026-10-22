package com.bytedance.android.livesdk.gift.fastgift.task;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.livesdk.gift.fastgift.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ly1.b;
import my1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/fastgift/task/FastTaskGiftConfirmDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FastTaskGiftConfirmDialog extends AppCompatDialog {
    public TextView a;
    public TextView b;
    public Button c;
    public TextView d;
    public final c e;
    public final a f;

    public interface a {
        void a();

        void cancel();
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        setContentView(2131565464);
        this.a = (TextView) findViewById(2131372164);
        this.b = (TextView) findViewById(2131372167);
        this.c = (Button) findViewById(2131372166);
        this.d = (TextView) findViewById(2131372163);
        c r4 = this.e;
        if (r4 == null) goto L10;
        TextView r0 = this.a;
        if (r0 == null) goto L7;
        r0.setText(r4.mainText);
    L7:
        TextView r1 = this.b;
        if (r1 == null) goto L10;
        r1.setText(r4.subText);
    L10:
        Button r5 = this.c;
        if (r5 == null) goto L13;
        r5.setOnClickListener(new ly1.a(this));
    L13:
        TextView r6 = this.d;
        if (r6 == null) goto L17;
        r6.setOnClickListener(new b(this));
        return;
    }

    public FastTaskGiftConfirmDialog(Context r2, c r3, t r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "callback");
        super(r2);
        this.e = r3;
        this.f = r4;
    }
}

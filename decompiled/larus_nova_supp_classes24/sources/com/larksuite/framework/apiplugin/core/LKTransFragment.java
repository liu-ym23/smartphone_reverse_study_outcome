package com.larksuite.framework.apiplugin.core;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larksuite/framework/apiplugin/core/LKTransFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "tag", "", "callback", "Lcom/larksuite/framework/apiplugin/core/LKCallProxyFragmentCallback;", "setCallback", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "Companion", "open-plugin-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class LKTransFragment extends Fragment {
    public String d;

    public static final class a {
    }

    static {
    }

    public LKTransFragment() {
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        String r4 = r3.getString("TAG");
    L6:
        this.d = r4;
        Log.i("LKTransFragment", "onCreate, tag=" + this.d);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        Log.i("LKTransFragment", "onActivityResult, requestCode=" + r3 + ", resultCode=" + r4);
        if (r5 != null) goto L5;
        new Intent();
    L5:
        FragmentActivity r6 = getActivity();
        String r7 = this.d;
        if (r6 == null) goto L11;
        if (r7 == null) goto L12;
        r6.getSupportFragmentManager().beginTransaction().remove(this).commitNow();
        return;
    L12:
        return;
    }
}

package com.bytedance.android.ec.core.hybrid.bridges;

import android.app.Dialog;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECNavigationBarColorMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECNavigationBarColorMethod extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    static {
    }

    public ECNavigationBarColorMethod() {
        this.e = "ec.setNavigationBarColor";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        String r0 = r10.optString("color", "");
        String r12 = r10.optString("parent_color", "");
        boolean r13 = true;
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        r11.onFailed(0, "color is empty");
        return;
    L9:
        AppCompatActivity r14 = getContext();
        if ((r14 instanceof AppCompatActivity) == true) goto L13;
        r11.onFailed(0, "context is not AppCompatActivity");
        return;
    L13:
        AppCompatActivity r15 = r14;
        List r16 = r15.getSupportFragmentManager().getFragments();
        int r17 = r16.size() - 1;
    L14:
        if (r17 < 0) goto L25;
        DialogFragment r18 = (Fragment) CollectionsKt.getOrNull(r16, r17);
        if ((r18 instanceof DialogFragment) == false) goto L24;
        DialogFragment r19 = r18;
        if (r19.isVisible() == false) goto L24;
        Lazy r20 = UIUtils.a;
        Dialog r21 = r19.getDialog();
        if (r21 == null) goto L22;
        Window r22 = r21.getWindow();
    L23:
        UIUtils.g(r22, r0);
        UIUtils.g(r15.getWindow(), r12);
    L26:
        if (r13 == true) goto L28;
        Lazy r23 = UIUtils.a;
        UIUtils.g(r15.getWindow(), r0);
    L28:
        r11.onSuccess(new JSONObject());
        return;
    L22:
        r22 = null;
    L24:
        r17 = r17 - 1;
        goto L14
    L25:
        r13 = false;
        goto L26
    L5:
        r1 = false;
        goto L6
    }
}

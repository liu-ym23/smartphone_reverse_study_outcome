package com.obric.oui.animation.easy;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"spring", "Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "(Landroid/view/View;)Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator;", "OUIAnimation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class c {
    public static final <T extends View> b<T> a(T r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Object r0 = r5.getTag(ZeusTransformUtils.mapRes(R.id.view_property_spring_animator_key, OaidModel.KEY_ID, "view_property_spring_animator_key"));
        if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L5;
        b<T> r1 = (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L9;
        b<T> r2 = new b(r5);
        r5.setTag(ZeusTransformUtils.mapRes(R.id.view_property_spring_animator_key, OaidModel.KEY_ID, "view_property_spring_animator_key"), r2);
        return r2;
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }
}

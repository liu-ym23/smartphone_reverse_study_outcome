package androidx.appcompat.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class AllCapsTransformationMethod implements TransformationMethod {
    private Locale mLocale;

    public AllCapsTransformationMethod(Context r3) {
        this.mLocale = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence r2, View r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.toString().toUpperCase(this.mLocale);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View r1, CharSequence r2, boolean r3, int r4, Rect r5) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
    }
}

package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\u001a:\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086\b¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0004*\u00020\nH\u0086\b¨\u0006\u000b"}, d2 = {"getSpans", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/text/Spanned;", CommonConsts.APM_INNER_EVENT_COST_START, "", "end", "(Landroid/text/Spanned;II)[Ljava/lang/Object;", "toSpanned", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpannedStringKt {
    public static final /* synthetic */ <T> T[] getSpans(Spanned r3, int r4, int r5) {
        Spanned r6 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r3, Spanned.class, "com.obric.memorydata.plugin");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T[]) r6.getSpans(r4, r5, (Class) ZeusTransformUtils.preCheckCast(Object.class, Class.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned r1, int r2, int r3, int r4, Object r5) {
        Spanned r6 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r1, Spanned.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = r6.length();
    L8:
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return r6.getSpans(r2, r3, (Class) ZeusTransformUtils.preCheckCast(Object.class, Class.class, "com.obric.memorydata.plugin"));
    }

    public static final Spanned toSpanned(CharSequence r2) {
        return (Spanned) ZeusTransformUtils.preCheckCast(SpannedString.valueOf((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin")), Spanned.class, "com.obric.memorydata.plugin");
    }
}

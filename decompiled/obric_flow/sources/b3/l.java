package b3;

import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f850a = null;

    static {
        f850a = MapsKt.mapOf(new Pair[]{TuplesKt.to("loadApplet", 101), TuplesKt.to("loadMainJS", 102), TuplesKt.to("runMainJS", 201), TuplesKt.to("loadWidget", 103), TuplesKt.to("loadWidgetTemplate", 104), TuplesKt.to("renderTemplate", Integer.valueOf(LynxErrorCode.LYNX_ERROR_CODE_RESOURCE)), TuplesKt.to("unexpectedError", Integer.valueOf(LynxErrorCode.LYNX_ERROR_CODE_UPDATE)), TuplesKt.to("unknownError", 402)});
    }
}

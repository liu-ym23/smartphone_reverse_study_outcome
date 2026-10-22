package zh0;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "bundle");
        if (r1.containsKey("Extra_Radio_Bgtype_Converter") == true) goto L5;
    L17:
        return false;
    L5:
        if (r1.containsKey("Extra_Radio_Image_Uri_Converter") == false) goto L17;
        if (r1.containsKey("Extra_Radio_Single_Static_Imagemodel_Converter") == false) goto L17;
        if (r1.containsKey("Extra_Radio_Static_Imagemodel_Converter") == false) goto L17;
        if (r1.containsKey("Extra_Radio_Animated_Imagemodel_Converter") == false) goto L17;
        if (r1.containsKey("Extra_Radio_IMAGE_TYPE") == false) goto L17;
        if (r1.containsKey("Extra_Radio_Public_Color") == false) goto L17;
        return true;
    }

    @JvmStatic
    public static final String[] b(py.k r6) {
        String[] r0 = new String[5];
        String r1 = "";
        if (r6 == null) goto L6;
        String r2 = r6.getAvgColor();
        if (r2 == null) goto L6;
    L7:
        r0[0] = r2;
        if (r6 == null) goto L11;
        String r3 = r6.getUri();
        if (r3 == null) goto L11;
    L12:
        r0[1] = r3;
        if (r6 == null) goto L22;
        List r4 = r6.getUrls();
        if (r4 == null) goto L22;
        if (CollectionsKt.getLastIndex(r4) < 0) goto L19;
        Object r5 = ListProtector.get(r4, 0);
    L20:
        String r7 = (String) r5;
        if (r7 == null) goto L22;
    L23:
        r0[2] = r7;
        if (r6 == null) goto L33;
        List r8 = r6.getUrls();
        if (r8 == null) goto L33;
        if (1 > CollectionsKt.getLastIndex(r8)) goto L30;
        Object r9 = ListProtector.get(r8, 1);
    L31:
        String r10 = (String) r9;
        if (r10 == null) goto L33;
    L34:
        r0[3] = r10;
        if (r6 == null) goto L46;
        List r11 = r6.getUrls();
        if (r11 == null) goto L46;
        if (2 > CollectionsKt.getLastIndex(r11)) goto L41;
        Object r12 = ListProtector.get(r11, 2);
    L42:
        String r13 = (String) r12;
        if (r13 == null) goto L46;
        r1 = r13;
        goto L46
    L41:
        r12 = "";
    L46:
        r0[4] = r1;
        return r0;
    L30:
        r9 = "";
    L33:
        r10 = "";
        goto L34
    L19:
        r5 = "";
    L22:
        r7 = "";
    L11:
        r3 = "";
    L6:
        r2 = "";
        goto L7
    }

    @JvmStatic
    public static final Bundle c(IVoiceLiveTheme r4) {
        Intrinsics.checkNotNullParameter(r4, "voiceLiveTheme");
        Bundle r0 = new Bundle();
        r0.putInt("Extra_Radio_IMAGE_TYPE", r4.getImageType());
        r0.putInt("Extra_Radio_Bgtype_Converter", r4.getBgType());
        String r1 = r4.getImageUri();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.putString("Extra_Radio_Image_Uri_Converter", r1);
        r0.putStringArray("Extra_Radio_Single_Static_Imagemodel_Converter", b(r4.getSingleStaticBackground()));
        r0.putStringArray("Extra_Radio_Static_Imagemodel_Converter", b(r4.getStaticBackground()));
        r0.putStringArray("Extra_Radio_Animated_Imagemodel_Converter", b(r4.getAnimatedBackground()));
        String r5 = r4.getPublicScreenColorValue();
        if (r5 == null) goto L9;
        r2 = r5;
    L9:
        r0.putString("Extra_Radio_Public_Color", r2);
        return r0;
    }
}

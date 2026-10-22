package s0c;

import com.ss.android.lark.photoeditor.impl.editaction.CropAndRotationAction;
import com.ss.android.photoeditor.crop_rotate.PhotoClipView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import pfc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    static {
    }

    public static ArrayList a(List r4) {
        Intrinsics.checkNotNullParameter(r4, "actions");
        ArrayList r0 = new ArrayList();
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        PhotoClipView.b r1 = (f.a) r5.next();
        if ((r1 instanceof PhotoClipView.b) == false) goto L4;
        CropAndRotationAction r2 = new CropAndRotationAction();
        PhotoClipView.b r3 = r1;
        r2.a = r3.c;
        r2.b = r3.d;
        r2.c = r3.e;
        r0.add(r2);
        goto L4
    L8:
        return r0;
    }
}

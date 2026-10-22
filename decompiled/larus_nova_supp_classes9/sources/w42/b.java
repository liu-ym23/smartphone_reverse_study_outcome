package w42;

import am2.x;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.a {
    public final boolean a;

    public static final class a {
    }

    static {
    }

    public b(boolean r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.a
    public final void a(tb2.d r4, f<?> r5) {
        Intrinsics.checkNotNullParameter(r4, "text");
        Intrinsics.checkNotNullParameter(r5, "absTextMessage");
        if (r5.v == false) goto L5;
        return;
    L5:
        Iterator<T> r6 = r4.a.iterator();
    L7:
        if (r6.hasNext() == false) goto L34;
        tb2.c r7 = (tb2.c) r6.next();
        if (r7.getType() != PieceType.IMAGE.getPieceType()) goto L7;
        ITextPieceImage r8 = r7.getImageValue();
        if (r8 == null) goto L15;
        k r9 = r8.getImageModel();
        if (r9 == null) goto L15;
        Integer r10 = r9.getImageType();
    L16:
        if (r10 == null) goto L7;
        if (r10.intValue() != 70) goto L7;
        LinkedHashMap r11 = new LinkedHashMap();
        if (this.a == false) goto L23;
        String r13 = "1";
    L24:
        r11.put("is_anchor", r13);
        j0.l().sendLog("livesdk_audience_activity_emoji_show", r11, new Object[]{IRoom.class, x.class});
        return;
    L23:
        r13 = "0";
    L15:
        r10 = null;
        goto L16
    }
}

package w42;

import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.h;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.a {
    public c() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.a
    public final void a(tb2.d r6, f<?> r7) {
        Intrinsics.checkNotNullParameter(r6, "text");
        Intrinsics.checkNotNullParameter(r7, "absTextMessage");
        Iterator<T> r8 = r6.a.iterator();
    L4:
        if (r8.hasNext() == false) goto L35;
        tb2.c r9 = (tb2.c) r8.next();
        if (r9.getType() != PieceType.IMAGE.getPieceType()) goto L4;
        ITextPieceImage r0 = r9.getImageValue();
        if (r0 == null) goto L12;
        k r1 = r0.getImageModel();
        if (r1 == null) goto L12;
        Integer r2 = r1.getImageType();
    L13:
        if (r2 == null) goto L4;
        if (r2.intValue() != 65) goto L4;
        Lazy r3 = PublicScreenABHelper.a;
        IRoomContextService r4 = jc1.k.f(IRoomContextService.class);
        if (r4 == null) goto L24;
        o r5 = IRoomContextService.a.a(r4, null, 0, 3);
        if (r5 == null) goto L24;
        m r10 = r5.getRoom();
        if (r10 == null) goto L24;
        IRoom r11 = (IRoom) r10.getValue();
    L26:
        if (PublicScreenABHelper.b(r11) == true) goto L29;
        r9.setSchemaKey(null);
        r9.setConvertedSchema(null);
    L29:
        if (PublicScreenABHelper.c() == false) goto L31;
        float r13 = PublicScreenABHelper.e();
    L32:
        int r14 = (int) (UtilityKotlinExtentionsKt.h(14.0f) * r13);
        ITextPieceImage r15 = r9.getImageValue();
        if (r15 == null) goto L4;
        r15.setHeight(r14);
        goto L4
    L31:
        r13 = h.a;
    L24:
        r11 = null;
    L12:
        r2 = null;
        goto L13
    }
}

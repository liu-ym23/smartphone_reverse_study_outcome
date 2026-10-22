package com.larus.avlink.impl;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.gallery.VideoVH;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.dora.IDoraEService;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.ExpiredInfo;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u001e\u0010\u0012\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/avlink/impl/DoraEServiceImpl;", "Lcom/larus/bmhome/dora/IDoraEService;", "<init>", "()V", "lastWearState", "", "TAG", "", "setExpiredText", "current", "Lcom/larus/im/bean/message/Message;", "getVideoVH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "shareVideoFile", "", "videoFile", "shareMediaFiles", "mediaFiles", "", "onlyShare", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEServiceImpl implements IDoraEService {
    public DoraEServiceImpl() {
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "videoFile");
        int r0 = ia8.h.a;
        Intrinsics.checkNotNullParameter(r2, "mediaFileStr");
        ia8.h.c(CollectionsKt.listOf(r2), true);
    }

    public final String b(Message r8) {
        Intrinsics.checkNotNullParameter(r8, "current");
        List r9 = hp8.a.a(r8.getContent()).getEntities();
        if (r9 == null) goto L11;
        UplinkFileEntity r10 = (UplinkFileEntity) ListProtector.get(r9, 0);
        if (r10 == null) goto L11;
        ExpiredInfo r11 = r10.getExpiredInfo();
        if (r11 == null) goto L11;
        Long r12 = r11.getExpireTime();
        if (r12 == null) goto L11;
        long r1 = r12.longValue();
    L12:
        long r2 = r1 - (System.currentTimeMillis() / ((long) 1000));
        if (r2 < 86400) goto L16;
        String r13 = MathKt.roundToInt(r2 / 86400.0f) + " 天";
    L23:
        return AppHost.a.getApplication().getString(2131908347, new Object[]{r13});
    L16:
        if (r2 < 3600) goto L19;
        r13 = MathKt.roundToInt(r2 / 3600.0f) + " 小时";
        goto L23
    L19:
        if (r2 < 60) goto L21;
        r13 = MathKt.roundToInt(r2 / 60.0f) + " 分钟";
        goto L23
    L21:
        r13 = "1 分钟";
    L11:
        r1 = Long.MAX_VALUE;
        goto L12
    }

    public final VideoVH c(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new VideoVH(LayoutInflater.from(r5.getContext()).inflate(2131562308, r5, false));
    }

    public final void d(List<String> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "mediaFiles");
        ia8.h.c(r2, r3);
    }
}

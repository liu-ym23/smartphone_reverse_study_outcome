package com.bytedance.android.live.revlink.impl.multianchor.utils;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x {
    public static final boolean a(int r1) {
        if (r1 != 7) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean b(int r1) {
        if (r1 != 9) goto L5;
    L10:
        return true;
    L5:
        if (r1 == 10) goto L10;
        if (r1 == 11) goto L10;
        return false;
    }

    public static final boolean c(int r1) {
        if (r1 != 21) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 20) goto L8;
        return false;
    }

    public static final boolean d(int r1) {
        if (r1 != 6) goto L5;
        return true;
    L5:
        return false;
    }

    public static final String f(int r0) {
        switch(r0) {
            case 1: goto L9;
            case 2: goto L3;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L3;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L3;
            case 9: goto L5;
            case 10: goto L4;
            case 11: goto L4;
            default: goto L3;
        };
    L3:
        return "";
    L4:
        return "triple_link";
    L5:
        return "single_link";
    L6:
        return "triple";
    L7:
        return "team_double";
    L8:
        return "link_double";
    L9:
        return "single";
    }

    public static final String g(List<? extends com.bytedance.android.livesdk.link.model.p> r9) {
        if (r9 == null) goto L14;
        ArrayList r0 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L5:
        if (r10.hasNext() == false) goto L12;
        IBaseUser r1 = ((com.bytedance.android.livesdk.link.model.p) r10.next()).getUser();
        if (r1 == null) goto L9;
        String r2 = r1.getIdString();
    L10:
        if (r2 == null) goto L5;
        r0.add(r2);
        goto L5
    L9:
        r2 = null;
        goto L10
    L12:
        String r12 = CollectionsKt.joinToString$default(r0, null, null, null, 0, null, null, 63, null);
        if (r12 == null) goto L14;
        return r12;
    L14:
        return "";
    }

    public static final String h(pc0.a r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toLogString");
        StringBuilder r1 = new StringBuilder("SeiAppData{ver=");
        r1.append(r10.getVersion());
        r1.append(",channelId=");
        r1.append(r10.getChannelId());
        r1.append(",timestamp=");
        r1.append(r10.getTimestamp());
        r1.append(",grids=");
        List r2 = r10.e();
        if (r2 == null) goto L5;
        Integer r3 = Integer.valueOf(r2.size());
    L6:
        r1.append(r3.intValue());
        r1.append(",[");
        List r12 = r10.e();
        if (r12 == null) goto L12;
        Iterator r13 = r12.iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        RevSeiRegion r4 = (RevSeiRegion) r13.next();
        Intrinsics.checkNotNullParameter(r4, "$this$toLogString");
        StringBuilder r5 = new StringBuilder("Region{type=");
        r5.append(r4.getType());
        r5.append(",w=");
        StringCompanionObject r6 = StringCompanionObject.INSTANCE;
        r5.append(String.format("%.3f", Arrays.copyOf(new Object[]{Double.valueOf(r4.getWidth())}, 1)));
        r5.append(",h=");
        r5.append(String.format("%.3f", Arrays.copyOf(new Object[]{Double.valueOf(r4.getHeight())}, 1)));
        r5.append(",x=");
        r5.append(String.format("%.3f", Arrays.copyOf(new Object[]{Double.valueOf(r4.getX())}, 1)));
        r5.append(",y=");
        r5.append(String.format("%.3f", Arrays.copyOf(new Object[]{Double.valueOf(r4.getY())}, 1)));
        r5.append(",stat=");
        r5.append(r4.getStatus());
        r5.append(",uid=");
        r5.append(r4.getUidStr());
        r5.append(",mute_audio=");
        r5.append(r4.getMuteAudio());
        r5.append("talk_volume=");
        r5.append(r4.getTalkVolume());
        r5.append("}");
        r1.append(r5.toString());
        r1.append(",");
    L12:
        r1.append("]}");
        return r1.toString();
    L5:
        r3 = null;
        goto L6
    }

    public static final <T> void e(LiveData<T> r1, Observer<T> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$observerForeverWithNotify");
        Intrinsics.checkNotNullParameter(r2, "observer");
        r1.observeForever(r2);
        Object r3 = r1.getValue();
        if (r3 == null) goto L6;
        r2.onChanged(r3);
        return;
    }
}

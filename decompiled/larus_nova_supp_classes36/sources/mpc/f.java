package mpc;

import android.content.Context;
import android.widget.ImageView;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;
import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardDoubaoContent;
import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardScene;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface f extends IOfficeSDKCapacity {
    void B(List<byte[]> r1);

    void cc(ForwardScene r1, g r2, boolean r3);

    boolean g1(Context r1, npc.a r2, List r3, String r4, u48.c r5);

    void g8(Context r1, ImageView r2, String r3, String r4, int r5, int r6);

    void gf(Context r1, ForwardDoubaoContent r2, List r3, u48.b r4);

    boolean i1(Context r1, npc.a r2);

    void o8(Context r1, npc.d r2);
}

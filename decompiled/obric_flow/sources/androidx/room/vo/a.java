package androidx.room.vo;

import com.bytedance.ies.xelement.LynxScrollView;
import com.bytedance.lynx.map.ng.LynxMapView;
import com.bytedance.map.api.collision.CollisionTextModel;
import com.bytedance.map.api.utils.CommonUtil;
import com.zte.miboard.cards.travel.TravelListAty;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f694a;

    public /* synthetic */ a(int r5) {
        this.f694a = r5;
    }

    @Override // java.util.Comparator
    public final int compare(Object r5, Object r10) {
        switch(this.f694a) {
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        int r11 = LynxScrollView.f6363l;
        return ((Integer) r5).intValue() - ((Integer) r10).intValue();
    L8:
        int r12 = LynxScrollView.f6363l;
        return ((Integer) r10).intValue() - ((Integer) r5).intValue();
    L5:
        return (int) (((Long) ((Map.Entry) r10).getValue()).longValue() - ((Long) ((Map.Entry) r5).getValue()).longValue());
    L11:
        return LynxMapView.b((CollisionTextModel) r5, (CollisionTextModel) r10);
    L13:
        return CommonUtil.a((Map.Entry) r5, (Map.Entry) r10);
    L15:
        return TravelListAty.j((String) r5, (String) r10);
    L17:
        return ((Double) r5).compareTo((Double) r10);
    L19:
        return SchemaIdentityKey.a((String) r5, (String) r10);
    }
}

package c;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.zte.miboard.cards.travel.TravelCard;
import com.zte.miboard.cards.travel.TravelListAty;
import com.zte.miboard.cards.travel.data.TravelData;
import com.zte.miboard.cards.travel.net.data.FlightReq;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1070a;

    public /* synthetic */ o(int r5) {
        this.f1070a = r5;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object r10) {
        switch(this.f1070a) {
            case 0: goto L18;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            default: goto L5;
        };
    L18:
        r r11 = (r) r10;
        if (r11 == null) goto L35;
        if (TextUtils.isEmpty(r11.f1076a) == true) goto L35;
        if (TextUtils.isEmpty(r11.f1077b) == true) goto L35;
        String r5 = r11.f1078c;
        boolean r12 = s0.f1083a;
        if (TextUtils.isEmpty(r5) == false) goto L27;
        boolean r13 = false;
    L28:
        if (r13 == false) goto L35;
        long r14 = r11.d;
        if (r14 <= 0) goto L35;
        if (r14 <= System.currentTimeMillis()) goto L35;
        return false;
    L27:
        r13 = URLUtil.isNetworkUrl(r5);
    L35:
        return true;
    L5:
        return com.zte.miboard.cards.travel.b.c((TravelData) r10);
    L7:
        return TravelListAty.i((TravelData) r10);
    L9:
        return TravelCard.b((TravelData) r10);
    L11:
        return TravelCard.c((FlightReq) r10);
    L13:
        return TravelCard.d((FlightReq) r10);
    L15:
        if (((Long) r10).longValue() == 0) goto L17;
        return false;
    L17:
        return true;
    }
}

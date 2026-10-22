package cp;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import com.obric.clockwidgets.data.WidgetClockCity;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME);
        String r5 = r10.readString();
        String r11 = r10.readString();
        String r12 = r10.readString();
        long r13 = r10.readLong();
        String r14 = r10.readString();
        String r15 = r10.readString();
        if (r14 == null) goto L8;
        TimeZone r16 = TimeZone.getTimeZone(r14);
        if (r16 == null) goto L8;
    L12:
        return new WidgetClockCity(r5, r11, r12, r13, r16, r15);
    L8:
        if (r12 == null) goto L10;
        r16 = TimeZone.getTimeZone(r12);
        goto L12
    L10:
        r16 = null;
        goto L12
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int r5) {
        return new WidgetClockCity[r5];
    }
}

package com.bytedance.android.monitorV2.hybridSetting.entity;

import a5.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.monitorV2.hybridSetting.entity.parcel.AbstractParcelableAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/entity/CheckFilter;", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/parcel/AbstractParcelableAdapter;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nCheckFilter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckFilter.kt\ncom/bytedance/android/monitorV2/hybridSetting/entity/CheckFilter\n+ 2 AbstractParcelableAdapter.kt\ncom/bytedance/android/monitorV2/hybridSetting/entity/parcel/AbstractParcelableAdapter\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,69:1\n74#2,7:70\n119#2,9:77\n81#2,3:86\n119#2,9:89\n64#2,4:98\n68#2:103\n109#2,4:104\n113#2,2:109\n116#2:112\n69#2:113\n71#2:115\n109#2,4:116\n113#2,2:121\n116#2:124\n1819#3:102\n1819#3:108\n1820#3:111\n1820#3:114\n1819#3:120\n1820#3:123\n*E\n*S KotlinDebug\n*F\n+ 1 CheckFilter.kt\ncom/bytedance/android/monitorV2/hybridSetting/entity/CheckFilter\n*L\n43#1,7:70\n45#1,9:77\n43#1,3:86\n50#1,9:89\n57#1,4:98\n57#1:103\n59#1,4:104\n59#1,2:109\n59#1:112\n57#1:113\n57#1:115\n63#1,4:116\n63#1,2:121\n63#1:124\n57#1:102\n59#1:108\n59#1:111\n57#1:114\n63#1:120\n63#1:123\n*E\n"})
public final class CheckFilter extends AbstractParcelableAdapter {

    @JvmField
    public static final Parcelable.Creator<CheckFilter> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f3601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f3602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3603c;

    static {
        CREATOR = new b(0);
    }

    public /* synthetic */ CheckFilter() {
        this(new HashMap(), new ArrayList(), "");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        int r11 = 0;
        HashMap r12 = this.f3601a;
        if (r12 == null) goto L5;
        int r13 = r12.size();
    L6:
        r5.writeInt(r13);
        if (r13 <= 0) goto L21;
        Intrinsics.checkNotNull(r12);
        Iterator r14 = r12.entrySet().iterator();
    L10:
        if (r14.hasNext() == false) goto L21;
        Map.Entry r15 = (Map.Entry) r14.next();
        r5.writeString((String) r15.getKey());
        List r16 = (List) r15.getValue();
        if (r16 == null) goto L14;
        int r17 = r16.size();
    L15:
        r5.writeInt(r17);
        if (r17 <= 0) goto L10;
        Intrinsics.checkNotNull(r16);
        Iterator r18 = r16.iterator();
    L19:
        if (r18.hasNext() == false) goto L10;
        r5.writeString((String) r18.next());
        goto L19
    L14:
        r17 = 0;
    L21:
        ArrayList r19 = this.f3602b;
        if (r19 == null) goto L24;
        r11 = r19.size();
    L24:
        r5.writeInt(r11);
        if (r11 <= 0) goto L30;
        Intrinsics.checkNotNull(r19);
        Iterator r20 = r19.iterator();
    L28:
        if (r20.hasNext() == false) goto L30;
        r5.writeString((String) r20.next());
    L30:
        r5.writeString(this.f3603c);
        return;
    L5:
        r13 = 0;
        goto L6
    }

    public CheckFilter(Parcel r11) {
        int r5 = r11.readInt();
        int r10 = 0;
        ArrayList r12 = null;
        if (r5 != 0) goto L5;
        HashMap r13 = null;
    L16:
        if (r13 != null) goto L18;
        r13 = new HashMap();
    L18:
        this.f3601a = r13;
        int r14 = r11.readInt();
        if (r14 == 0) goto L24;
        r12 = new ArrayList();
    L22:
        if (r10 >= r14) goto L24;
        String r15 = r11.readString();
        Intrinsics.checkNotNull(r15);
        r12.add(r15);
        r10 = r10 + 1;
    L24:
        if (r12 != null) goto L26;
        r12 = new ArrayList();
    L26:
        this.f3602b = r12;
        String r16 = r11.readString();
        Intrinsics.checkNotNull(r16);
        this.f3603c = r16;
        return;
    L5:
        r13 = new LinkedHashMap();
        int r17 = 0;
    L6:
        if (r17 >= r5) goto L16;
        String r18 = r11.readString();
        Intrinsics.checkNotNull(r18);
        int r19 = r11.readInt();
        if (r19 != 0) goto L10;
        ArrayList r20 = null;
    L13:
        if (r20 != null) goto L15;
        r20 = new ArrayList();
    L15:
        Pair r21 = new Pair(r18, r20);
        r13.put(r21.getFirst(), r21.getSecond());
        r17 = r17 + 1;
        goto L6
    L10:
        r20 = new ArrayList();
        int r22 = 0;
    L11:
        if (r22 >= r19) goto L13;
        String r23 = r11.readString();
        Intrinsics.checkNotNull(r23);
        r20.add(r23);
        r22 = r22 + 1;
        goto L11
    }

    public CheckFilter(HashMap r5, ArrayList r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "filter");
        Intrinsics.checkNotNullParameter(r10, "category");
        Intrinsics.checkNotNullParameter(r11, "id");
        this.f3601a = r5;
        this.f3602b = r10;
        this.f3603c = r11;
    }
}

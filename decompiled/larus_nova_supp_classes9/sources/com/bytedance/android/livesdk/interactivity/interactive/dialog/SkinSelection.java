package com.bytedance.android.livesdk.interactivity.interactive.dialog;

import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.android.livesdk.chatroom.msgboard.b;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import n82.c;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class SkinSelection {
    public String a;
    public String b;
    public Set<String> c;
    public DressType d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/SkinSelection$DressType;", BuildConfig.FLAVOR, "UNKNOWN", "SKIN", "BADGE", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum DressType extends Enum<DressType> {
        public static final DressType BADGE = null;
        public static final DressType SKIN = null;
        public static final DressType UNKNOWN = null;
        public static final /* synthetic */ DressType[] a = null;

        static {
            DressType r1 = new DressType("UNKNOWN", 0);
            UNKNOWN = r1;
            DressType r2 = new DressType("SKIN", 1);
            SKIN = r2;
            DressType r3 = new DressType("BADGE", 2);
            BADGE = r3;
            a = new DressType[]{r1, r2, r3};
        }

        public static DressType valueOf(String r1) {
            return (DressType) a.a(DressType.class, r1);
        }

        public static DressType[] values() {
            return (DressType[]) a.clone();
        }

        public DressType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public SkinSelection() {
        this.a = BuildConfig.FLAVOR;
        this.b = BuildConfig.FLAVOR;
        this.c = new LinkedHashSet();
        this.d = DressType.UNKNOWN;
    }

    public final boolean a(DataCenter r5) {
        if (CollectionUtils.isEmpty(this.c) == true) goto L29;
        Set<String> r0 = this.c;
        if (r0 == null) goto L30;
        Set<String> r1 = r0;
        if ((r1 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r2 = r1.iterator();
    L13:
        if (r2.hasNext() == false) goto L20;
        if (c.c((String) r2.next(), r5) == true) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == false) goto L13;
        boolean r6 = true;
    L21:
        if (r6 != true) goto L31;
        return true;
    L31:
        return false;
    L17:
        r3 = false;
    L20:
        r6 = false;
        goto L21
    L9:
        if (r1.isEmpty() == false) goto L11;
    L30:
        return false;
    L29:
        return false;
    }

    public final void b(DataCenter r5) {
        b r6 = c.i(r5);
        Set<String> r0 = this.c;
        if (r0 != null) goto L5;
        r0 = new LinkedHashSet();
    L5:
        this.c = r0;
        r0.clear();
        if (r6 == null) goto L19;
        List r1 = r6.a();
        if (r1 == null) goto L19;
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L19;
        VSMsgBoardDress r3 = (VSMsgBoardDress) r2.next();
        if (String.valueOf(r3.getDressId()).equals(this.b) == true) goto L16;
        if (String.valueOf(r3.getDressId()).equals(this.a) == false) goto L11;
    L16:
        String r4 = String.valueOf(r3.getEntityId());
        Set<String> r7 = this.c;
        if (r7 == null) goto L11;
        r7.add(r4);
    L19:
        if (r6 == null) goto L32;
        List r8 = r6.c();
        if (r8 == null) goto L49;
        Iterator r9 = r8.iterator();
    L24:
        if (r9.hasNext() == false) goto L50;
        VSMsgBoardDress r10 = (VSMsgBoardDress) r9.next();
        if (String.valueOf(r10.getDressId()).equals(this.b) == true) goto L29;
        if (String.valueOf(r10.getDressId()).equals(this.a) == false) goto L24;
    L29:
        String r11 = String.valueOf(r10.getEntityId());
        Set<String> r13 = this.c;
        if (r13 == null) goto L24;
        r13.add(r11);
        goto L24
    L50:
        return;
    L49:
        return;
    }
}

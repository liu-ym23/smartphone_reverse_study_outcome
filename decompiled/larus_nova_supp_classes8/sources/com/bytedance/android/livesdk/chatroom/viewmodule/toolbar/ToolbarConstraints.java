package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.e81;
import com.bytedance.android.livesdk.utils.r6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.annotations.SerializedName;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarConstraints;", "", "", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarSlot;", "slots", "Ljava/util/List;", "a", "()Ljava/util/List;", "<init>", "()V", "Companion", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ToolbarConstraints {
    public static final Map<String, WeakReference<ToolbarConstraints>> e = null;
    public static final Companion f = null;
    public final Map<String, ToolbarSlot> a;
    public DataCenter b;
    public final Map<String, h2> c;
    public final List<ToolbarSlot> d;

    @SerializedName("slots")
    private final List<ToolbarSlot> slots;

    public static final class Companion {
        public Companion() {
        }

        public static void a(ToolbarConstraints r13) {
            Map<String, h2> r0 = r13.c;
            Map<String, ToolbarSlot> r1 = r13.a;
            Iterator<T> r2 = r13.a().iterator();
        L4:
            if (r2.hasNext() == false) goto L22;
            ToolbarSlot r3 = (ToolbarSlot) r2.next();
            if (r3.c() == true) goto L7;
            Iterator<T> r4 = r3.d().iterator();
            int r6 = 0;
        L10:
            if (r4.hasNext() == false) goto L4;
            Object r7 = r4.next();
            int r8 = r6 + 1;
            if (r6 >= 0) goto L14;
            CollectionsKt.throwIndexOverflow();
        L14:
            int r9 = r3.d().size() - r6;
            Iterator r10 = ((List) r7).iterator();
            int r11 = 0;
        L16:
            if (r10.hasNext() == false) goto L21;
            Object r12 = r10.next();
            int r14 = r11 + 1;
            if (r11 >= 0) goto L20;
            CollectionsKt.throwIndexOverflow();
        L20:
            String r15 = (String) r12;
            r0.put(r15, new h2.a((r3.getPriority() << 16) | (r9 << 8)));
            r1.put(r15, r3);
            r11 = r14;
            goto L16
        L21:
            r6 = r8;
            goto L10
        L7:
            ((ArrayList) r13.d).add(r3);
            goto L4
        }

        public static void b(final ToolbarConstraints r10) {
            int r0 = u3.a;
            StringBuilder r1 = new StringBuilder("Constraint AB, sort: ");
            SettingKey<Integer> r2 = e81.e;
            r1.append((Integer) r2.getValue());
            u3.a(r1.toString());
            Integer r3 = (Integer) r2.getValue();
            if (r3 == null) goto L9;
            if (r3.intValue() != 0) goto L9;
            return;
        L9:
            if (r3 != null) goto L12;
        L14:
            if (r3 != null) goto L17;
            return;
        L17:
            if (r3.intValue() != 2) goto L74;
            final int r4 = d4.a((h2) ((LinkedHashMap) r10.c).get(ToolbarButton.GIFT.name()));
            ToolbarSlot r5 = (ToolbarSlot) ((LinkedHashMap) r10.a).get(ToolbarButton.FAST_GIFT.name());
            int r6 = r6.a;
            if (((Boolean) LiveInfraSettingKeys.LIVE_TOOLBAR_RAISE_PRIORITY_FAST_GIFT_SLOT.getValue()).booleanValue() != true) goto L29;
            if (r5 == null) goto L29;
            List<List<String>> r7 = r5.d();
            if (r7 == null) goto L29;
            List r8 = CollectionsKt.flatten(r7);
            if (r8 == null) goto L29;
            Iterator r9 = r8.iterator();
        L27:
            if (r9.hasNext() == false) goto L29;
            String r11 = (String) r9.next();
            final int r12 = d4.a((h2) ((LinkedHashMap) r10.c).get(r11));
            final int r13 = (2147418112 & r4) + (r12 & 65280);
            r10.c.put(r11, new h2.b(new ToolbarConstraints$Companion$transformConstraintWithSortingAb$$inlined$forEach$lambda$1(r13, r12, r10, r4)));
        L29:
            ToolbarSlot r14 = (ToolbarSlot) ((LinkedHashMap) r10.a).get(ToolbarButton.INTERACTION.name());
            if (r14 == null) goto L39;
            List<List<String>> r15 = r14.d();
            if (r15 == null) goto L39;
            List r16 = CollectionsKt.flatten(r15);
            if (r16 == null) goto L39;
            Iterator r17 = r16.iterator();
        L37:
            if (r17.hasNext() == false) goto L39;
            String r18 = (String) r17.next();
            final int r19 = d4.a((h2) ((LinkedHashMap) r10.c).get(r18));
            final int r20 = (r19 & 65280) + 0;
            r10.c.put(r18, new h2.b(new ToolbarConstraints$Companion$transformConstraintWithSortingAb$$inlined$forEach$lambda$2(r19, r20, r10)));
        L39:
            Iterator<T> r110 = r10.a().iterator();
        L40:
            Object r21 = null;
            if (r110.hasNext() == false) goto L45;
            Object r22 = r110.next();
            if (((ToolbarSlot) r22).c() == false) goto L40;
        L46:
            ToolbarSlot r23 = (ToolbarSlot) r22;
            if (r23 != null) goto L49;
            return;
        L49:
            Iterator<T> r111 = r23.d().iterator();
        L51:
            if (r111.hasNext() == false) goto L60;
            Object r24 = r111.next();
            List r25 = (List) r24;
            if (r25.size() == 1) goto L55;
        L57:
            boolean r26 = false;
        L58:
            if (r26 == false) goto L51;
            r21 = r24;
            goto L60
        L55:
            if (Intrinsics.areEqual((String) CollectionsKt.first(r25), ToolbarButton.INTERACTION_ROOM.name()) == false) goto L57;
            r26 = true;
        L60:
            List r27 = (List) r21;
            if (r27 == null) goto L75;
            r23.d().remove(r27);
            return;
        L75:
            return;
        L45:
            r22 = null;
            goto L46
        L74:
            return;
        L12:
            if (r3.intValue() != 1) goto L14;
        }
    }

    static {
        f = new Companion();
        e = new LinkedHashMap();
    }

    public ToolbarConstraints() {
        this.slots = CollectionsKt.emptyList();
        this.a = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new ArrayList();
    }

    public List<ToolbarSlot> a() {
        return this.slots;
    }
}

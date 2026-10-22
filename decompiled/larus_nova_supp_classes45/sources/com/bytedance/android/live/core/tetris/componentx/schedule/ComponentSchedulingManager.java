package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentBatchPriorityCellConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentBatchPriorityMappingConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentManagerABHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ComponentSchedulingManager {
    public final String a;
    public j b;
    public f c;
    public SchedueType d;
    public g70.a e;
    public Map<f70.b, LayerDescriptorList> f;
    public b g;
    public q h;
    public ComponentBatchBaseLoadState i;
    public boolean j;
    public final int k;
    public ScenInfo l;
    public h70.b m;
    public final LinkedHashMap<f70.b, LinkedHashMap<Integer, m>> n;
    public LinkedHashMap<Integer, m> o;
    public final Map<String, j70.h<? extends h70.b>> p;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/core/tetris/componentx/schedule/ComponentSchedulingManager$ScenInfo;", "", "AUDIENCE_LANDSCAPE", "AUDIENCE_PORTRAIT", "ANCHOR", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ScenInfo extends Enum<ScenInfo> {
        public static final ScenInfo ANCHOR = null;
        public static final ScenInfo AUDIENCE_LANDSCAPE = null;
        public static final ScenInfo AUDIENCE_PORTRAIT = null;
        public static final /* synthetic */ ScenInfo[] a = null;

        static {
            ScenInfo r1 = new ScenInfo("AUDIENCE_LANDSCAPE", 0);
            AUDIENCE_LANDSCAPE = r1;
            ScenInfo r2 = new ScenInfo("AUDIENCE_PORTRAIT", 1);
            AUDIENCE_PORTRAIT = r2;
            ScenInfo r3 = new ScenInfo("ANCHOR", 2);
            ANCHOR = r3;
            a = new ScenInfo[]{r1, r2, r3};
        }

        public static ScenInfo valueOf(String r1) {
            return (ScenInfo) r27.a.a(ScenInfo.class, r1);
        }

        public static ScenInfo[] values() {
            return (ScenInfo[]) a.clone();
        }

        public ScenInfo(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/core/tetris/componentx/schedule/ComponentSchedulingManager$SchedueType;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "Companion", "a", "TOGETHER", "INORDER", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SchedueType extends Enum<SchedueType> {
        public static final a Companion = null;
        public static final SchedueType INORDER = null;
        public static final SchedueType TOGETHER = null;
        public static final /* synthetic */ SchedueType[] a = null;
        private final String key;

        public static final class a {
            public a() {
            }
        }

        static {
            SchedueType r1 = new SchedueType("TOGETHER", 0, "together");
            TOGETHER = r1;
            SchedueType r2 = new SchedueType("INORDER", 1, "inorder");
            INORDER = r2;
            a = new SchedueType[]{r1, r2};
            Companion = new a();
        }

        public static SchedueType valueOf(String r1) {
            return (SchedueType) r27.a.a(SchedueType.class, r1);
        }

        public static SchedueType[] values() {
            return (SchedueType[]) a.clone();
        }

        public final String getKey() {
            return this.key;
        }

        public SchedueType(String r1, int r2, String r3) {
            super(r1, r2);
            this.key = r3;
        }
    }

    public interface a {
        void a(f70.b r1, int r2, m r3);
    }

    public interface b {
        void a(int r1, m r2, boolean r3);
    }

    public final List<j70.f> c() {
        ArrayList r0 = new ArrayList();
        Map<String, j70.h<? extends h70.b>> r1 = this.p;
        if (r1 == null) goto L16;
        Iterator r2 = ((LinkedHashMap) r1).entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L16;
        Map.Entry r3 = (Map.Entry) r2.next();
        h70.b r4 = this.m;
        if (r4 == null) goto L6;
        j70.h r5 = (j70.h) r3.getValue();
        if ((r5 instanceof j70.h) == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L6;
        j70.f r6 = r5.C(r4);
        if (r6 == null) goto L6;
        r0.add(r6);
    L16:
        return r0;
    }

    public final void g() {
        ComponentBatchBaseLoadState r0 = this.i;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        Map<String, j70.h<? extends h70.b>> r1 = this.p;
        if (r1 == null) goto L8;
        ((LinkedHashMap) r1).clear();
    L8:
        LinkedHashMap<Integer, m> r2 = this.o;
        if (r2 == null) goto L11;
        r2.clear();
    L11:
        LinkedHashMap<f70.b, LinkedHashMap<Integer, m>> r3 = this.n;
        if (r3 == null) goto L14;
        r3.clear();
    L14:
        this.j = false;
        this.b = null;
        ALogger.i(this.a, "OnDestory");
    }

    public ComponentSchedulingManager() {
        this.a = "ComponentSchedulingManager";
        this.d = SchedueType.TOGETHER;
        this.k = 3;
        this.l = ScenInfo.AUDIENCE_PORTRAIT;
        this.n = new LinkedHashMap();
        this.o = new LinkedHashMap();
        this.p = new LinkedHashMap();
    }

    public final LayerDescriptorList a(LayerDescriptorList r3) {
        Intrinsics.checkNotNullParameter(r3, "descriptorList");
        g70.a r0 = this.e;
        if (r0 == null) goto L5;
        LayerDescriptorList r1 = r0.a(r3);
    L6:
        this.j = true;
        if (r1 != null) goto L10;
        return r3;
    L10:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final l b(j70.h<h70.b> r15) {
        l r0 = new l();
        h70.b r1 = this.m;
        if (r1 == null) goto L77;
        j70.f r2 = r15.C(r1);
        String r3 = "";
        if (r2 == null) goto L8;
        String r4 = r2.b;
        if (r4 == null) goto L8;
    L9:
        j70.f r5 = r15.C(r1);
        if (r5 == null) goto L15;
        String r6 = r5.a;
        if (r6 == null) goto L15;
        r3 = r6;
    L15:
        String r7 = r4.concat(r3);
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r0.a = r7;
        double r8 = 0.0d;
        if (this.m != null) goto L18;
        double r9 = 0.0d;
    L29:
        h70.b r11 = this.m;
        ElementConstraint r12 = null;
        if (r11 == null) goto L59;
        j70.f r13 = r15.C(r11);
        if (r13 == null) goto L34;
        String r14 = r13.b;
    L35:
        ALogger.d("ComponentLocalPrioritysConfig", "enable = " + LiveInfraSettingKeys.LIVE_COMPONENT_DYNAMIC_BATCH_CONFIG.getValue().getEnable());
        f r16 = this.c;
        if (r16 != null) goto L38;
    L46:
        j r17 = this.b;
        if (r17 == null) goto L51;
        Map<String, Double> r18 = r17.c;
        if (r18 == null) goto L51;
        Double r19 = r18.get(r14);
    L52:
        if (r19 != null) goto L55;
        r8 = r9;
        goto L59
    L55:
        if ((true ^ Intrinsics.areEqual(r9, r19)) == false) goto L57;
        double r21 = r19.doubleValue();
    L58:
        r8 = r21;
        goto L59
    L57:
        r21 = r19.doubleValue();
    L51:
        r19 = null;
        goto L52
    L38:
        if (r16.b() != true) goto L46;
        f r110 = this.c;
        Intrinsics.checkNotNull(r110);
        r110.getClass();
        Double r111 = (Double) ((LinkedHashMap) k.a).get(r14);
        if (r111 == null) goto L42;
        double r112 = r111.doubleValue();
    L44:
        if (r112 == 0.0d) goto L46;
        ALogger.d("ComponentLocalPrioritysConfig", "tag is " + r14 + "  localPriority = " + r112);
        r9 = r112;
        goto L46
    L42:
        r112 = 0.0d;
        goto L44
    L34:
        r14 = null;
    L59:
        r0.b = r8;
        if ((r15 instanceof j70.n) == false) goto L63;
        ((j70.n) r15).h();
    L63:
        if ((r15 instanceof e70.a) == false) goto L65;
        ((e70.a) r15).O().u();
    L65:
        int r22 = d80.a.a;
        h70.b r23 = this.m;
        if (r23 == null) goto L68;
        r12 = r15.J(r23);
    L68:
        LinkedHashMap r24 = new LinkedHashMap();
        if (r12 == null) goto L76;
        List<ElementConstraint.c> r25 = r12.j;
        if (r25 == null) goto L76;
        Iterator r26 = ((ArrayList) r25).iterator();
    L74:
        if (r26.hasNext() == false) goto L76;
        r24.put(DependencyEnum.BEFORE, ((ElementConstraint.c) r26.next()).b.c);
    L76:
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r15.B(r1);
        r0.c = r15;
        goto L77
    L18:
        int r27 = n.b[this.l.ordinal()];
        if (r27 != 1) goto L21;
        h70.b r28 = this.m;
        Intrinsics.checkNotNull(r28);
        r9 = r15.F(r28);
        goto L29
    L21:
        if (r27 != 2) goto L23;
        h70.b r29 = this.m;
        Intrinsics.checkNotNull(r29);
        r9 = r15.H(r29);
        goto L29
    L23:
        if (r27 != 3) goto L26;
        h70.b r31 = this.m;
        Intrinsics.checkNotNull(r31);
        r9 = r15.G(r31);
        goto L29
    L26:
        throw new NoWhenBranchMatchedException();
    L8:
        r4 = "";
    L77:
        return r0;
    }

    public final Map<f70.b, LayerDescriptorList> d(Map<f70.b, List<j70.f>> r9) {
        Intrinsics.checkNotNullParameter(r9, "componentsElementTypeList");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<f70.b, List<j70.f>>> r11 = r9.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L18;
        Map.Entry<f70.b, List<j70.f>> r1 = r11.next();
        LayerDescriptorList r2 = new LayerDescriptorList();
        Iterator<T> r3 = r1.getValue().iterator();
    L7:
        if (r3.hasNext() == false) goto L17;
        j70.f r4 = (j70.f) r3.next();
        Map<String, j70.h<? extends h70.b>> r5 = this.p;
        String r6 = null;
        if (r4 == null) goto L11;
        String r7 = r4.b;
    L12:
        if (r4 == null) goto L14;
        r6 = r4.a;
    L14:
        j70.h r8 = (j70.h) ((LinkedHashMap) r5).get(Intrinsics.stringPlus(r7, r6));
        if (r8 == null) goto L7;
        r2.add(r8);
        goto L7
    L11:
        r7 = null;
        goto L12
    L17:
        r0.put(r1.getKey(), r2);
        goto L4
    L18:
        return r0;
    }

    public final void e(Map<f70.b, LayerDescriptorList> r24) {
        int r2 = n.a[this.d.ordinal()];
        String r4 = " description = ";
        String r5 = "createComponentSchedulingInfo ___ tag = ";
        if (r2 != 1) goto L5;
        Intrinsics.checkNotNullParameter(r24, "layerDescriptorList");
        Iterator<Map.Entry<f70.b, LayerDescriptorList>> r1 = r24.entrySet().iterator();
    L101:
        if (r1.hasNext() == false) goto L212;
        Map.Entry<f70.b, LayerDescriptorList> r3 = r1.next();
        f70.b r9 = r3.getKey();
        LayerDescriptorList r6 = a(r3.getValue());
        LinkedHashMap r11 = new LinkedHashMap();
        if (r6 == null) goto L144;
        Iterator<j70.h<? extends h70.b>> r7 = r6.iterator();
    L106:
        if (r7.hasNext() == false) goto L144;
        j70.h<h70.b> r12 = (j70.h) r7.next();
        h70.b r13 = this.m;
        if (r13 == null) goto L106;
        boolean r14 = r12 instanceof j70.h;
        if (r14 == true) goto L112;
        j70.h<h70.b> r15 = null;
    L113:
        if (r15 == null) goto L118;
        j70.f r16 = r15.C(r13);
        if (r16 == null) goto L118;
        String r17 = r16.b;
        if (r17 == null) goto L118;
    L119:
        if (r14 == true) goto L121;
        j70.h<h70.b> r18 = null;
    L122:
        if (r18 == null) goto L127;
        j70.f r19 = r18.C(r13);
        if (r19 == null) goto L127;
        String r110 = r19.a;
        if (r110 == null) goto L127;
    L128:
        if (r14 == true) goto L130;
        j70.h<h70.b> r111 = null;
    L131:
        if (r111 == null) goto L133;
        l r112 = b(r111);
    L135:
        if (ComponentManagerABHelper.INSTANCE.enableFullLog() == false) goto L137;
        ALogger.i(this.a, r5 + r17 + r4 + r110);
    L137:
        r11.put(r17.concat(r110), r112);
        if (r14 == true) goto L140;
        j70.h<h70.b> r8 = null;
    L141:
        if (r8 == null) goto L106;
        Map<String, j70.h<? extends h70.b>> r113 = this.p;
        StringBuilder r114 = new StringBuilder();
        h70.b r115 = this.m;
        Intrinsics.checkNotNull(r115);
        r114.append(r8.C(r115).b);
        h70.b r116 = this.m;
        Intrinsics.checkNotNull(r116);
        r114.append(r8.C(r116).a);
        r113.put(r114.toString(), r12);
        goto L106
    L140:
        r8 = r12;
        goto L141
    L133:
        r112 = null;
        goto L135
    L130:
        r111 = r12;
    L127:
        r110 = "";
        goto L128
    L121:
        r18 = r12;
    L118:
        r17 = "";
        goto L119
    L112:
        r15 = r12;
    L144:
        Iterator r21 = r11.entrySet().iterator();
    L146:
        if (r21.hasNext() == false) goto L101;
        Map.Entry r22 = (Map.Entry) r21.next();
        l r23 = (l) r22.getValue();
        if (r23 == null) goto L150;
        double r25 = r23.b;
    L151:
        l r117 = (l) r22.getValue();
        if (r117 == null) goto L155;
        String r118 = r117.a;
        if (r118 == null) goto L155;
    L156:
        int r26 = f(r25, r118);
        m r119 = this.o.get(Integer.valueOf(r26));
        m r120 = this.o.get(Integer.valueOf(r26));
        if (r120 == null) goto L159;
        List<l> r121 = r120.a;
    L160:
        m r122 = this.o.get(Integer.valueOf(r26));
        if (r122 == null) goto L163;
        LayerDescriptorList r123 = r122.b;
    L164:
        if (r121 != null) goto L166;
        r121 = new ArrayList();
    L166:
        if (r123 != null) goto L168;
        r123 = new LayerDescriptorList();
    L168:
        if (r119 != null) goto L170;
        r119 = new m(r121, r123);
    L170:
        l r27 = (l) r22.getValue();
        if (r27 == null) goto L199;
        j70.h r124 = (j70.h) ((LinkedHashMap) this.p).get(r27.a);
        if (r124 == null) goto L199;
        if (r123.contains(r124) == true) goto L198;
        Intrinsics.checkNotNullParameter(r27, "newInfo");
        Intrinsics.checkNotNullParameter(r121, "infoList");
        Iterator<l> r125 = r121.iterator();
        int r126 = 0;
    L177:
        Iterator<Map.Entry<f70.b, LayerDescriptorList>> r127 = r1;
        if (r125.hasNext() == false) goto L186;
        Iterator r128 = r21;
        String r28 = r4;
        String r29 = r5;
        if (r125.next().b <= r27.b) goto L182;
        boolean r31 = true;
    L183:
        if (r31 == true) goto L184;
        r126 = r126 + 1;
        r21 = r128;
        r1 = r127;
        r4 = r28;
        r5 = r29;
        goto L177
    L184:
        int r32 = -1;
    L187:
        if (r126 != r32) goto L189;
        r121.add(r27);
    L196:
        if (ComponentManagerABHelper.INSTANCE.enableFullLog() == false) goto L200;
        ALogger.i(this.a, "loadingList  当前添加的组件为 " + r124);
    L200:
        r123.clear();
        ArrayList r33 = new ArrayList();
        Iterator<T> r34 = r121.iterator();
    L202:
        if (r34.hasNext() == false) goto L206;
        j70.h<? extends h70.b> r35 = ((l) r34.next()).c;
        if (r35 == null) goto L202;
        r33.add(r35);
        goto L202
    L206:
        Iterator r36 = r33.iterator();
    L208:
        if (r36.hasNext() == false) goto L210;
        r123.add((j70.h) r36.next());
        goto L208
    L210:
        r119.a = r121;
        r119.b = r123;
        this.o.put(Integer.valueOf(r26), r119);
        r21 = r128;
        r1 = r127;
        r4 = r28;
        r5 = r29;
        goto L146
    L189:
        l r37 = (l) CollectionsKt.getOrNull(r121, r126);
        if (r37 != null) goto L192;
    L194:
        ListProtector.add(r121, r126, r27);
        goto L196
    L192:
        if (r37.b != r27.b) goto L194;
        r121.add(r27);
        goto L196
    L182:
        r31 = false;
        goto L183
    L186:
        r128 = r21;
        r28 = r4;
        r29 = r5;
        r32 = -1;
        r126 = -1;
        goto L187
    L198:
        r127 = r1;
        r128 = r21;
        r28 = r4;
        r29 = r5;
        ALogger.i(this.a, "重复组件 loadingList " + r124);
    L199:
        r127 = r1;
        r128 = r21;
        r28 = r4;
        r29 = r5;
        goto L200
    L163:
        r123 = null;
        goto L164
    L159:
        r121 = null;
    L155:
        r118 = "unknow";
        goto L156
    L150:
        r25 = 0.0d;
        goto L151
    L212:
        LinkedHashMap<Integer, m> r38 = this.o;
        if (ComponentManagerABHelper.INSTANCE.enableRoomSceneSchedulerPrioritylevelCheck() == true) goto L217;
        if (r38 == null) goto L216;
        SortedMap r129 = MapsKt.toSortedMap(r38);
    L241:
        this.o = new LinkedHashMap(r129);
        return;
    L216:
        r129 = null;
        goto L241
    L217:
        f r39 = this.c;
        if (r39 != null) goto L220;
        int r41 = this.k;
    L229:
        if (r41 < 0) goto L237;
        int r42 = 0;
    L232:
        if (r38.containsKey(Integer.valueOf(r42)) == true) goto L234;
        SortedMap r43 = null;
        r38.put(Integer.valueOf(r42), new m(null, null));
    L235:
        if (r42 == r41) goto L238;
        r42 = r42 + 1;
    L238:
        if (r38 == null) goto L240;
        r129 = MapsKt.toSortedMap(r38);
        goto L241
    L240:
        r129 = r43;
        goto L241
    L234:
        r43 = null;
        goto L235
    L237:
        r43 = null;
        goto L238
    L220:
        if (r39.b() == false) goto L227;
        List<ComponentBatchPriorityCellConfig> r44 = r39.a;
        if (r44 == null) goto L226;
        ComponentBatchPriorityCellConfig r45 = (ComponentBatchPriorityCellConfig) CollectionsKt.last(r44);
        if (r45 == null) goto L226;
        r41 = r45.getBatch();
    L226:
        r41 = 0;
        goto L229
    L227:
        r41 = 3;
        goto L229
    L5:
        if (r2 != 2) goto L272;
        Intrinsics.checkNotNullParameter(r24, "layerDescriptorList");
        Iterator<Map.Entry<f70.b, LayerDescriptorList>> r46 = r24.entrySet().iterator();
    L9:
        if (r46.hasNext() == false) goto L273;
        Map.Entry<f70.b, LayerDescriptorList> r47 = r46.next();
        f70.b r130 = r47.getKey();
        LayerDescriptorList r48 = r47.getValue();
        LinkedHashMap r131 = new LinkedHashMap();
        LayerDescriptorList r49 = a(r48);
        if (r49 == null) goto L53;
        Iterator<j70.h<? extends h70.b>> r51 = r49.iterator();
    L14:
        if (r51.hasNext() == false) goto L53;
        j70.h<h70.b> r132 = (j70.h) r51.next();
        h70.b r133 = this.m;
        if (r133 == null) goto L14;
        boolean r134 = r132 instanceof j70.h;
        if (r134 == true) goto L20;
        j70.h<h70.b> r52 = null;
    L21:
        if (r52 == null) goto L26;
        j70.f r53 = r52.C(r133);
        if (r53 == null) goto L26;
        String r54 = r53.b;
        if (r54 == null) goto L26;
    L27:
        if (r134 == true) goto L29;
        j70.h<h70.b> r55 = null;
    L30:
        if (r55 == null) goto L35;
        j70.f r56 = r55.C(r133);
        if (r56 == null) goto L35;
        String r57 = r56.a;
        if (r57 == null) goto L35;
    L36:
        if (r134 == true) goto L38;
        j70.h<h70.b> r135 = null;
    L39:
        if (r135 == null) goto L41;
        l r136 = b(r135);
    L43:
        if (ComponentManagerABHelper.INSTANCE.enableFullLog() == false) goto L46;
        ALogger.i(this.a, "createComponentSchedulingInfo ___ tag = " + r54 + " description = " + r57);
    L46:
        r131.put(r54.concat(r57), r136);
        if (r134 == true) goto L49;
        j70.h<h70.b> r58 = null;
    L50:
        if (r58 == null) goto L52;
        Map<String, j70.h<? extends h70.b>> r59 = this.p;
        StringBuilder r61 = new StringBuilder();
        h70.b r137 = this.m;
        Intrinsics.checkNotNull(r137);
        r61.append(r58.C(r137).b);
        h70.b r138 = this.m;
        Intrinsics.checkNotNull(r138);
        r61.append(r58.C(r138).a);
        r59.put(r61.toString(), r132);
    L52:
        r46 = r46;
        goto L14
    L49:
        r58 = r132;
        goto L50
    L41:
        r136 = null;
        goto L43
    L38:
        r135 = r132;
    L35:
        r57 = "";
        goto L36
    L29:
        r55 = r132;
    L26:
        r54 = "";
        goto L27
    L20:
        r52 = r132;
    L53:
        Iterator<Map.Entry<f70.b, LayerDescriptorList>> r210 = r46;
        LinkedHashMap r62 = new LinkedHashMap();
        Iterator r63 = r131.entrySet().iterator();
    L55:
        if (r63.hasNext() == false) goto L98;
        Map.Entry r64 = (Map.Entry) r63.next();
        l r65 = (l) r64.getValue();
        if (r65 == null) goto L59;
        double r139 = r65.b;
    L60:
        l r66 = (l) r64.getValue();
        if (r66 == null) goto L64;
        String r67 = r66.a;
        if (r67 == null) goto L64;
    L65:
        int r68 = f(r139, r67);
        m r140 = (m) r62.get(Integer.valueOf(r68));
        m r141 = (m) r62.get(Integer.valueOf(r68));
        if (r141 == null) goto L68;
        List<l> r142 = r141.a;
    L69:
        m r143 = (m) r62.get(Integer.valueOf(r68));
        if (r143 == null) goto L72;
        LayerDescriptorList r144 = r143.b;
    L73:
        if (r142 != null) goto L75;
        r142 = new ArrayList();
    L75:
        if (r144 != null) goto L77;
        r144 = new LayerDescriptorList();
    L77:
        if (r140 != null) goto L79;
        r140 = new m(r142, r144);
    L79:
        l r69 = (l) r64.getValue();
        if (r69 == null) goto L87;
        j70.h r145 = (j70.h) ((LinkedHashMap) this.p).get(r69.a);
        if (r145 == null) goto L87;
        if (r144.contains(r145) == true) goto L86;
        r144.add(r145);
        r142.add(r69);
        goto L87
    L86:
        ALogger.i(this.a, "重复组件 loadingList " + r145);
    L87:
        r144.clear();
        ArrayList r146 = new ArrayList();
        Iterator<T> r71 = r142.iterator();
    L89:
        if (r71.hasNext() == false) goto L93;
        j70.h<? extends h70.b> r147 = ((l) r71.next()).c;
        if (r147 == null) goto L89;
        r146.add(r147);
        goto L89
    L93:
        Iterator r72 = r146.iterator();
    L95:
        if (r72.hasNext() == false) goto L97;
        r144.add((j70.h) r72.next());
        goto L95
    L97:
        r140.a = r142;
        r140.b = r144;
        this.o.put(Integer.valueOf(r68), r140);
        goto L55
    L72:
        r144 = null;
        goto L73
    L68:
        r142 = null;
    L64:
        r67 = "unknow";
        goto L65
    L59:
        r139 = 0.0d;
        goto L60
    L98:
        this.n.put(r130, new LinkedHashMap(MapsKt.toSortedMap(r62)));
        r46 = r210;
        goto L9
    L273:
        return;
    }

    public final int f(double r8, String r11) {
        Intrinsics.checkNotNullParameter(r11, "name");
        f r0 = this.c;
        if (r0 != null) goto L5;
        int r1 = (int) r8;
    L25:
        ALogger.i(this.a, "name = " + r11 + " ____ priority = " + r8 + " ____ priorityLevel = " + r1);
        return r1;
    L5:
        if (r0.b() == false) goto L23;
        List<ComponentBatchPriorityCellConfig> r2 = r0.a;
        ComponentBatchPriorityCellConfig r3 = null;
        Object r4 = null;
        if (r2 == null) goto L20;
        Iterator<T> r5 = r2.iterator();
    L10:
        if (r5.hasNext() == false) goto L19;
        Object r6 = r5.next();
        ComponentBatchPriorityCellConfig r7 = (ComponentBatchPriorityCellConfig) r6;
        if (r8 >= r7.getStart()) goto L14;
    L16:
        boolean r9 = false;
    L17:
        if (r9 == false) goto L10;
        r4 = r6;
        goto L19
    L14:
        if (r8 >= r7.getEnd()) goto L16;
        r9 = true;
    L19:
        r3 = (ComponentBatchPriorityCellConfig) r4;
    L20:
        if (r3 == null) goto L22;
        r1 = r3.getBatch();
        goto L25
    L22:
        r1 = f.c(r8);
        goto L25
    L23:
        r1 = f.c(r8);
        goto L25
    }

    public final void h(c r11, com.bytedance.android.live.core.tetris.componentx.c r12, q r13) {
        Intrinsics.checkNotNullParameter(r11, "conditionConfig");
        Intrinsics.checkNotNullParameter(r12, "loadNotify");
        this.g = r12;
        f r0 = this.c;
        LinkedHashMap r1 = new LinkedHashMap();
        int r3 = 0;
    L4:
        if (r3 >= 10) goto L28;
        if (r0 == null) goto L23;
        if (r0.b() != true) goto L23;
        if (LiveInfraSettingKeys.LIVE_SUBBATCH_LOAD_FIX.getValue().booleanValue() == false) goto L16;
        ComponentBatchPriorityMappingConfig r7 = LiveInfraSettingKeys.LIVE_COMPONENT_DYNAMIC_BATCH_CONFIG.getValue().getPriorityMapping();
        if (r7 == null) goto L14;
        int r8 = r7.getP0_end();
    L15:
        int r9 = r8 + 1;
    L18:
        if (r11.a == false) goto L21;
        if (r3 != r9) goto L21;
        r1.put(Integer.valueOf(r3), SetsKt.mutableSetOf(new BatchTogetherConditionManager.BatchLoadConditionType[]{BatchTogetherConditionManager.BatchLoadConditionType.END_DELAY_TIME, BatchTogetherConditionManager.BatchLoadConditionType.END_BATCH_ONLOAD, BatchTogetherConditionManager.BatchLoadConditionType.END_ROOM_ENTER}));
    L27:
        r3 = r3 + 1;
    L21:
        r1.put(Integer.valueOf(r3), SetsKt.mutableSetOf(new BatchTogetherConditionManager.BatchLoadConditionType[]{BatchTogetherConditionManager.BatchLoadConditionType.END_DELAY_TIME, BatchTogetherConditionManager.BatchLoadConditionType.END_BATCH_ONLOAD}));
        goto L27
    L14:
        r8 = 0;
        goto L15
    L16:
        r9 = 1;
    L23:
        if (r11.a == false) goto L26;
        if (r3 != 1) goto L26;
        r1.put(Integer.valueOf(r3), SetsKt.mutableSetOf(new BatchTogetherConditionManager.BatchLoadConditionType[]{BatchTogetherConditionManager.BatchLoadConditionType.END_DELAY_TIME, BatchTogetherConditionManager.BatchLoadConditionType.END_BATCH_ONLOAD, BatchTogetherConditionManager.BatchLoadConditionType.END_ROOM_ENTER}));
    L26:
        r1.put(Integer.valueOf(r3), SetsKt.mutableSetOf(new BatchTogetherConditionManager.BatchLoadConditionType[]{BatchTogetherConditionManager.BatchLoadConditionType.END_DELAY_TIME, BatchTogetherConditionManager.BatchLoadConditionType.END_BATCH_ONLOAD}));
        goto L27
    L28:
        int r14 = n.c[this.d.ordinal()];
        if (r14 == 1) goto L33;
        if (r14 != 2) goto L41;
        e r15 = new e(this.n, this.b, r13, new p(this, r12));
        this.i = r15;
        r15.g(r1);
        return;
    L41:
        return;
    L33:
        i r16 = new i(this.o, r13, new o(this, r12), this.c);
        this.i = r16;
        r16.e(r1);
    }
}

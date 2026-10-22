package com.ss.android.lark.media;

import android.text.TextUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MediaMutex {
    public static final MediaMutex r = null;
    public final Map<String, WeakReference<com.ss.android.lark.media.a>> a;
    public final Map<String, Scene> b;
    public String c;
    public String d;
    public ArrayList<String> e;
    public Scene f;
    public Scene g;
    public ArrayList<Scene> h;
    public final Map<String, String> i;
    public final Map<String, String> j;
    public final Map<String, ArrayList<String>> k;
    public final Map<Scene, Scene> l;
    public final Map<Scene, Scene> m;
    public final Map<Scene, ArrayList<Scene>> n;
    public final Map<String, Priority> o;
    public final Map<String, Priority> p;
    public final HashMap<Scene, SceneMediaConfig> q;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/media/MediaMutex$LockError;", "Ljava/lang/Error;", "Lkotlin/Error;", "occupiedScene", "Lcom/ss/android/lark/media/Scene;", "errorMessage", "", "<init>", "(Lcom/ss/android/lark/media/Scene;Ljava/lang/String;)V", "getOccupiedScene", "()Lcom/ss/android/lark/media/Scene;", "getErrorMessage", "()Ljava/lang/String;", "lark-media_release"}, k = 1, mv = {2, 0, 0}, xi = AnchorFit.END)
    public static final class LockError extends Error {
        private final String errorMessage;
        private final Scene occupiedScene;

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final Scene getOccupiedScene() {
            return this.occupiedScene;
        }

        public LockError(Scene r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "occupiedScene");
            Intrinsics.checkNotNullParameter(r3, "errorMessage");
            super(r2.name());
            this.occupiedScene = r2;
            this.errorMessage = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/media/MediaMutex$MediaConfig;", "Ljava/io/Serializable;", "type", "Lcom/ss/android/lark/media/MediaType;", "priority", "Lcom/ss/android/lark/media/Priority;", "<init>", "(Lcom/ss/android/lark/media/MediaType;Lcom/ss/android/lark/media/Priority;)V", "getType", "()Lcom/ss/android/lark/media/MediaType;", "getPriority", "()Lcom/ss/android/lark/media/Priority;", "lark-media_release"}, k = 1, mv = {2, 0, 0}, xi = AnchorFit.END)
    public static final class MediaConfig implements Serializable {
        private final Priority priority;
        private final MediaType type;

        public final Priority getPriority() {
            return this.priority;
        }

        public final MediaType getType() {
            return this.type;
        }

        public MediaConfig(MediaType r2, Priority r3) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r3, "priority");
            this.type = r2;
            this.priority = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/media/MediaMutex$SceneMediaConfig;", "Ljava/io/Serializable;", "scene", "Lcom/ss/android/lark/media/Scene;", "mediaConfig", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/media/MediaMutex$MediaConfig;", "mixWithOthers", "", "sceneDescription", "", "<init>", "(Lcom/ss/android/lark/media/Scene;Ljava/util/ArrayList;ZLjava/lang/String;)V", "getScene", "()Lcom/ss/android/lark/media/Scene;", "getMediaConfig", "()Ljava/util/ArrayList;", "getMixWithOthers", "()Z", "setMixWithOthers", "(Z)V", "getSceneDescription", "()Ljava/lang/String;", "lark-media_release"}, k = 1, mv = {2, 0, 0}, xi = AnchorFit.END)
    public static final class SceneMediaConfig implements Serializable {
        private final ArrayList<MediaConfig> mediaConfig;
        private boolean mixWithOthers;
        private final Scene scene;
        private final String sceneDescription;

        public final ArrayList<MediaConfig> getMediaConfig() {
            return this.mediaConfig;
        }

        public final boolean getMixWithOthers() {
            return this.mixWithOthers;
        }

        public final Scene getScene() {
            return this.scene;
        }

        public final String getSceneDescription() {
            return this.sceneDescription;
        }

        public final void setMixWithOthers(boolean r1) {
            this.mixWithOthers = r1;
        }

        public SceneMediaConfig(Scene r2, ArrayList<MediaConfig> r3, boolean r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            Intrinsics.checkNotNullParameter(r3, "mediaConfig");
            this.scene = r2;
            this.mediaConfig = r3;
            this.mixWithOthers = r4;
            this.sceneDescription = r5;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaType.values().length];
            r0[MediaType.Camera.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MediaType.Audio_Record.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MediaType.Audio_Play.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        r = new MediaMutex();
    }

    public MediaMutex() {
        this.a = new HashMap();
        this.b = new HashMap();
        this.e = new ArrayList();
        this.h = new ArrayList();
        this.i = new HashMap();
        this.j = new HashMap();
        this.k = new HashMap();
        this.l = new EnumMap(Scene.class);
        this.m = new EnumMap(Scene.class);
        this.n = new EnumMap(Scene.class);
        this.o = new HashMap();
        this.p = new HashMap();
        Scene r2 = Scene.VC_MEETING;
        MediaType r7 = MediaType.Camera;
        Priority r8 = Priority.High;
        MediaType r10 = MediaType.Audio_Record;
        MediaType r12 = MediaType.Audio_Play;
        MediaConfig[] r5 = {new MediaConfig(r7, r8), new MediaConfig(r10, r8), new MediaConfig(r12, r8)};
        Scene r3 = Scene.VC_RINGING;
        MediaConfig[] r6 = {new MediaConfig(r12, r8)};
        Scene r4 = Scene.VOIP_MEETING;
        MediaConfig[] r9 = {new MediaConfig(r10, r8), new MediaConfig(r12, r8)};
        Scene r11 = Scene.VOIP_RINGING;
        MediaConfig[] r13 = {new MediaConfig(r12, r8)};
        Scene r14 = Scene.Minutes_Record;
        Priority r15 = Priority.Medium;
        MediaConfig[] r16 = {new MediaConfig(r10, r15)};
        Scene r17 = Scene.Minutes_Play;
        Priority r18 = Priority.Default;
        MediaConfig[] r19 = {new MediaConfig(r12, r18)};
        Scene r20 = Scene.IM_Video_Record;
        MediaConfig[] r21 = {new MediaConfig(r7, r18), new MediaConfig(r10, r18)};
        Scene r22 = Scene.IM_Video_Play;
        MediaConfig[] r23 = {new MediaConfig(r12, r15)};
        Scene r24 = Scene.IM_Audio_Record;
        MediaConfig[] r25 = {new MediaConfig(r10, r18)};
        Scene r26 = Scene.IM_Audio_Play;
        MediaConfig[] r27 = {new MediaConfig(r12, r15)};
        Scene r28 = Scene.IM_Camera;
        MediaConfig[] r29 = {new MediaConfig(r7, r18)};
        Scene r30 = Scene.Little_App_Audio_Play;
        Priority r110 = Priority.Low;
        MediaConfig[] r111 = {new MediaConfig(r10, r110), new MediaConfig(r12, r18)};
        Scene r31 = Scene.Little_App_Scan;
        MediaConfig[] r32 = {new MediaConfig(r7, r18)};
        Scene r33 = Scene.Little_App_Audio_Record;
        MediaConfig[] r34 = {new MediaConfig(r10, r18)};
        Scene r35 = Scene.Little_App_Video_Record;
        MediaConfig[] r36 = {new MediaConfig(r7, r18), new MediaConfig(r10, r18)};
        Scene r37 = Scene.CCM_Audio_Record;
        MediaConfig[] r38 = {new MediaConfig(r10, r18)};
        Scene r0 = Scene.CCM_Video_Record;
        MediaConfig[] r39 = {new MediaConfig(r7, r18), new MediaConfig(r10, r18)};
        Scene r1 = Scene.CCM_Photo;
        MediaConfig[] r40 = {new MediaConfig(r7, r18)};
        Scene r41 = Scene.CCM_Audio_Play;
        MediaConfig[] r42 = {new MediaConfig(r12, r18)};
        Scene r43 = Scene.VC_RING_TONE;
        MediaConfig[] r44 = {new MediaConfig(r12, r18)};
        Scene r45 = Scene.NOTIFICATION_PLAY;
        MediaConfig[] r46 = {new MediaConfig(r12, r15)};
        Scene r47 = Scene.VC_VOICE_PRINT_RECORD;
        MediaConfig[] r48 = {new MediaConfig(r10, r110)};
        Scene r49 = Scene.DOUBAO_RECORD;
        this.q = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(r2, new SceneMediaConfig(r2, CollectionsKt.arrayListOf(r5), true, "View_G_Meeting_Fill")), TuplesKt.to(r3, new SceneMediaConfig(r3, CollectionsKt.arrayListOf(r6), false, "View_G_Meeting_Fill")), TuplesKt.to(r4, new SceneMediaConfig(r4, CollectionsKt.arrayListOf(r9), true, "View_G_Meeting_Fill")), TuplesKt.to(r11, new SceneMediaConfig(r11, CollectionsKt.arrayListOf(r13), false, "View_G_Meeting_Fill")), TuplesKt.to(r14, new SceneMediaConfig(r14, CollectionsKt.arrayListOf(r16), false, "View_G_FeishuMinutes")), TuplesKt.to(r17, new SceneMediaConfig(r17, CollectionsKt.arrayListOf(r19), false, "View_G_FeishuMinutes")), TuplesKt.to(r20, new SceneMediaConfig(r20, CollectionsKt.arrayListOf(r21), false, "View_G_Video_Fill")), TuplesKt.to(r22, new SceneMediaConfig(r22, CollectionsKt.arrayListOf(r23), false, "View_G_Video_Fill")), TuplesKt.to(r24, new SceneMediaConfig(r24, CollectionsKt.arrayListOf(r25), false, "View_G_Voice_Fill")), TuplesKt.to(r26, new SceneMediaConfig(r26, CollectionsKt.arrayListOf(r27), true, "View_G_Voice_Fill")), TuplesKt.to(r28, new SceneMediaConfig(r28, CollectionsKt.arrayListOf(r29), false, "View_G_Camera_Fill")), TuplesKt.to(r30, new SceneMediaConfig(r30, CollectionsKt.arrayListOf(r111), false, "View_G_App_Fill")), TuplesKt.to(r31, new SceneMediaConfig(r31, CollectionsKt.arrayListOf(r32), false, "View_G_App_Fill")), TuplesKt.to(r33, new SceneMediaConfig(r33, CollectionsKt.arrayListOf(r34), false, "View_G_App_Fill")), TuplesKt.to(r35, new SceneMediaConfig(r35, CollectionsKt.arrayListOf(r36), false, "View_G_App_Fill")), TuplesKt.to(r37, new SceneMediaConfig(r37, CollectionsKt.arrayListOf(r38), false, "View_G_Docs_Fill")), TuplesKt.to(r0, new SceneMediaConfig(r0, CollectionsKt.arrayListOf(r39), false, "View_G_Docs_Fill")), TuplesKt.to(r1, new SceneMediaConfig(r1, CollectionsKt.arrayListOf(r40), false, "View_G_Docs_Fill")), TuplesKt.to(r41, new SceneMediaConfig(r41, CollectionsKt.arrayListOf(r42), false, "View_G_Docs_Fill")), TuplesKt.to(r43, new SceneMediaConfig(r43, CollectionsKt.arrayListOf(r44), false, "View_G_Meeting_Fill")), TuplesKt.to(r45, new SceneMediaConfig(r45, CollectionsKt.arrayListOf(r46), false, "View_G_Voice_Fill")), TuplesKt.to(r47, new SceneMediaConfig(r47, CollectionsKt.arrayListOf(r48), false, "View_G_Recording_Fill")), TuplesKt.to(r49, new SceneMediaConfig(r49, CollectionsKt.arrayListOf(new MediaConfig[]{new MediaConfig(r10, r18)}), false, "View_G_FeishuMinutes"))});
    }

    public final List<Scene> a() {
        ArrayList r0 = new ArrayList();
        Scene r1 = this.g;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        Iterator r2 = ((EnumMap) this.m).values().iterator();
    L7:
        if (r2.hasNext() == false) goto L14;
        Scene r3 = (Scene) r2.next();
        if (r3 == null) goto L7;
        if (r0.contains(r3) == true) goto L7;
        r0.add(r3);
        goto L7
    L14:
        if (r0.isEmpty() == false) goto L24;
        return null;
    L24:
        return r0;
    }

    public final String c(Scene r4) {
        Iterator r0 = ((HashMap) this.b).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) r0.next();
        if (r4 != r1.getValue()) goto L4;
        return (String) r1.getKey();
    L9:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ArrayList<String> d(Scene r5) {
        ArrayList<String> r0 = new ArrayList();
        Iterator r1 = ((HashMap) this.b).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) r1.next();
        if (r5 != r2.getValue()) goto L4;
        r0.add(r2.getKey());
        goto L4
    L8:
        return r0;
    }

    public final Priority b(Scene r4, MediaType r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        SceneMediaConfig r6 = this.q.get(r4);
        if (r6 == null) goto L16;
        ArrayList<MediaConfig> r7 = r6.getMediaConfig();
        if (r7 == null) goto L16;
        Iterator<MediaConfig> r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L16;
        MediaConfig r1 = r8.next();
        if (r1.getType() != r5) goto L11;
        return r1.getPriority();
    L16:
        return null;
    }

    public final boolean e(Scene r2, MediaType r3) {
        SceneMediaConfig r4 = this.q.get(r2);
        if (r4 == null) goto L13;
        ArrayList<MediaConfig> r5 = r4.getMediaConfig();
        if (r5 == null) goto L18;
        Iterator<MediaConfig> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L19;
        if (r6.next().getType() != r3) goto L8;
        return true;
    L19:
        return false;
    L18:
        return false;
    L13:
        return false;
    }

    public final void g(Scene r7, String r8) {
        ArrayList<String> r0 = (ArrayList) ((HashMap) this.k).get(r8);
        boolean r1 = false;
        if (r0 == null) goto L18;
        Iterator r2 = ((HashMap) this.a).entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) r2.next();
        String r4 = (String) r3.getKey();
        WeakReference r5 = (WeakReference) r3.getValue();
        if (r0.contains(r4) == false) goto L6;
        Scene r6 = (Scene) ((HashMap) this.b).get(r8);
        MediaType r9 = MediaType.Audio_Play;
        if (e(r6, r9) == false) goto L6;
        com.ss.android.lark.media.a r10 = (com.ss.android.lark.media.a) r5.get();
        if (r10 == null) goto L14;
        r10.c(r7, r9);
    L14:
        this.e = r0;
        ArrayList<Scene> r11 = (ArrayList) ((EnumMap) this.n).get(r7);
        if (r11 == null) goto L17;
        this.h = r11;
    L17:
        r1 = true;
    L18:
        if (r1 == true) goto L28;
        this.e.remove(r8);
        this.h.remove(r7);
        return;
    }

    public final void h(Scene r4, com.ss.android.lark.media.a r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r4);
        r0.append(r5.hashCode());
        String r6 = r0.toString();
        String r1 = this.d;
        if (r1 == null) goto L9;
        ((HashMap) this.j).put(r6, r1);
        Map<Scene, Scene> r2 = this.m;
        EnumMap r3 = (EnumMap) r2;
        r3.put(r4, this.g);
        MediaType r7 = MediaType.Audio_Record;
        WeakReference r8 = (WeakReference) ((HashMap) this.a).get(r1);
        if (r8 == null) goto L9;
        com.ss.android.lark.media.a r9 = (com.ss.android.lark.media.a) r8.get();
        if (r9 == null) goto L9;
        r9.b(r4, r7);
    L9:
        this.d = r6;
        this.g = r4;
    }

    public final void i(Scene r7, String r8) {
        String r0 = (String) ((HashMap) this.j).get(r8);
        boolean r1 = false;
        if (r0 == null) goto L15;
        Iterator r2 = ((HashMap) this.a).entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L15;
        Map.Entry r3 = (Map.Entry) r2.next();
        String r4 = (String) r3.getKey();
        WeakReference r5 = (WeakReference) r3.getValue();
        if (Intrinsics.areEqual(r4, r0) == false) goto L6;
        Scene r6 = (Scene) ((HashMap) this.b).get(r8);
        MediaType r9 = MediaType.Audio_Record;
        if (e(r6, r9) == false) goto L6;
        com.ss.android.lark.media.a r10 = (com.ss.android.lark.media.a) r5.get();
        if (r10 == null) goto L14;
        r10.c(r7, r9);
    L14:
        this.d = r0;
        this.g = (Scene) ((EnumMap) this.m).get(r7);
        r1 = true;
    L15:
        if (r1 == true) goto L25;
        this.d = null;
        this.g = null;
        return;
    }

    public final void j(Scene r4, com.ss.android.lark.media.a r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r4);
        r0.append(r5.hashCode());
        String r6 = r0.toString();
        String r1 = this.c;
        if (r1 == null) goto L9;
        ((HashMap) this.i).put(r6, r1);
        Map<Scene, Scene> r2 = this.l;
        EnumMap r3 = (EnumMap) r2;
        r3.put(r4, this.f);
        MediaType r7 = MediaType.Camera;
        WeakReference r8 = (WeakReference) ((HashMap) this.a).get(r1);
        if (r8 == null) goto L9;
        com.ss.android.lark.media.a r9 = (com.ss.android.lark.media.a) r8.get();
        if (r9 == null) goto L9;
        r9.b(r4, r7);
    L9:
        this.c = r6;
        this.f = r4;
    }

    public final void k(Scene r7, String r8) {
        String r0 = (String) ((HashMap) this.i).get(r8);
        boolean r1 = false;
        if (r0 == null) goto L15;
        Iterator r2 = ((HashMap) this.a).entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L15;
        Map.Entry r3 = (Map.Entry) r2.next();
        String r4 = (String) r3.getKey();
        WeakReference r5 = (WeakReference) r3.getValue();
        if (Intrinsics.areEqual(r4, r0) == false) goto L6;
        Scene r6 = (Scene) ((HashMap) this.b).get(r8);
        MediaType r9 = MediaType.Camera;
        if (e(r6, r9) == false) goto L6;
        com.ss.android.lark.media.a r10 = (com.ss.android.lark.media.a) r5.get();
        if (r10 == null) goto L14;
        r10.c(r7, r9);
    L14:
        this.c = r0;
        this.f = (Scene) ((EnumMap) this.l).get(r7);
        r1 = true;
    L15:
        if (r1 == true) goto L25;
        this.c = null;
        this.f = null;
        return;
    }

    public final boolean m(MediaConfig r8, com.ss.android.lark.media.a r9) {
        Priority r0 = b(this.f, MediaType.Camera);
        Iterator r1 = ((HashMap) this.o).keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        String r2 = (String) r1.next();
        Scene r4 = this.f;
        if (r4 == null) goto L4;
        if (StringsKt.startsWith$default(r2, String.valueOf(r4), false, 2, null) == false) goto L4;
        r0 = (Priority) ((HashMap) this.o).get(r2);
        goto L4
    L10:
        if (r0 != null) goto L12;
    L17:
        boolean r10 = true;
    L18:
        if (r10 == true) goto L23;
        Scene r3 = this.f;
        if (r3 == null) goto L23;
        MediaType.a r5 = MediaType.Companion;
        r9.a(new LockError(r3, ""));
        return false;
    L23:
        return r10;
    L12:
        if (r0.compareTo(r8.getPriority()) <= 0) goto L14;
    L16:
        r10 = false;
        goto L18
    L14:
        if (r0 == Priority.High) goto L16;
        goto L16
    }

    public final void n(Scene r7, com.ss.android.lark.media.a r8) {
        Intrinsics.checkNotNullParameter(r7, "scene");
        monitor-enter(this);
        o(r7, r8);     // Catch: Throwable -> L72
        SceneMediaConfig r0 = this.q.get(r7);     // Catch: Throwable -> L72
        if (r0 == null) goto L49;
        ArrayList<MediaConfig> r1 = r0.getMediaConfig();     // Catch: Throwable -> L72
        if (r1 == null) goto L49;
        Iterator<MediaConfig> r2 = r1.iterator();     // Catch: Throwable -> L72
    L10:
        if (r2.hasNext() == false) goto L49;
        MediaType r3 = r2.next().getType();     // Catch: Throwable -> L72
        int r4 = b.a[r3.ordinal()];     // Catch: Throwable -> L72
        if (r4 != 1) goto L13;
        if (r8 == null) goto L41;
    L45:
        if (r8 == null) goto L10;
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L72
        r5.append(r7);     // Catch: Throwable -> L72
        r5.append(r8.hashCode());     // Catch: Throwable -> L72
        String r6 = r5.toString();     // Catch: Throwable -> L72
        if (TextUtils.equals(this.c, r6) == false) goto L10;
        k(r7, r6);     // Catch: Throwable -> L72
        ((HashMap) this.o).remove(r6);     // Catch: Throwable -> L72
        goto L10
    L41:
        if (this.f != r7) goto L45;
        String r9 = c(r7);     // Catch: Throwable -> L72
        if (r9 == null) goto L45;
        k(r7, r9);     // Catch: Throwable -> L72
        Priority r10 = (Priority) ((HashMap) this.o).remove(r9);     // Catch: Throwable -> L72
        goto L45
    L13:
        if (r4 != 2) goto L15;
        if (r8 == null) goto L31;
    L35:
        if (r8 == null) goto L10;
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L72
        r11.append(r7);     // Catch: Throwable -> L72
        r11.append(r8.hashCode());     // Catch: Throwable -> L72
        String r12 = r11.toString();     // Catch: Throwable -> L72
        if (TextUtils.equals(this.d, r12) == false) goto L10;
        i(r7, r12);     // Catch: Throwable -> L72
        goto L10
    L31:
        if (this.g != r7) goto L35;
        String r13 = c(r7);     // Catch: Throwable -> L72
        if (r13 == null) goto L35;
        i(r7, r13);     // Catch: Throwable -> L72
        goto L35
    L15:
        if (r4 != 3) goto L28;
        if (r8 == null) goto L18;
    L23:
        if (r8 == null) goto L10;
        StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L72
        r14.append(r7);     // Catch: Throwable -> L72
        r14.append(r8.hashCode());     // Catch: Throwable -> L72
        String r15 = r14.toString();     // Catch: Throwable -> L72
        if (this.e.contains(r15) == false) goto L10;
        g(r7, r15);     // Catch: Throwable -> L72
        goto L10
    L18:
        if (this.h.contains(r7) == false) goto L23;
        Iterator<String> r16 = d(r7).iterator();     // Catch: Throwable -> L72
    L21:
        if (r16.hasNext() == false) goto L23;
        g(r7, r16.next());     // Catch: Throwable -> L72
        goto L21
    L28:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L72
    L49:
        Iterator r17 = ((HashMap) this.o).keySet().iterator();     // Catch: Throwable -> L72
    L51:
        if (r17.hasNext() == false) goto L61;
        String r18 = (String) r17.next();     // Catch: Throwable -> L72
        if (r7 == null) goto L51;
        if (StringsKt.startsWith$default(r18, r7.toString(), false, 2, null) == false) goto L51;
        if (((Priority) ((HashMap) this.o).get(r18)) == null) goto L51;
        String r19 = c(r7);     // Catch: Throwable -> L72
        if (r19 == null) goto L51;
        k(r7, r19);     // Catch: Throwable -> L72
        goto L51
    L61:
        if (r8 != null) goto L69;
        ArrayList<String> r20 = d(r7);     // Catch: Throwable -> L72
        HashMap r21 = new HashMap();     // Catch: Throwable -> L72
        r21.putAll(this.b);     // Catch: Throwable -> L72
        ((HashMap) this.b).clear();     // Catch: Throwable -> L72
        Iterator r22 = r21.entrySet().iterator();     // Catch: Throwable -> L72
    L64:
        if (r22.hasNext() == false) goto L68;
        Map.Entry r23 = (Map.Entry) r22.next();     // Catch: Throwable -> L72
        if (r20.contains(r23.getKey()) == true) goto L64;
        Map<String, Scene> r24 = this.b;     // Catch: Throwable -> L72
        HashMap r25 = (HashMap) r24;     // Catch: Throwable -> L72
        r25.put(r23.getKey(), r23.getValue());     // Catch: Throwable -> L72
        goto L64
    L68:
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L72
    L70:
        monitor-exit(this);
        return;
    L69:
        StringBuilder r27 = new StringBuilder();     // Catch: Throwable -> L72
        r27.append(r7);     // Catch: Throwable -> L72
        r27.append(r8.hashCode());     // Catch: Throwable -> L72
        String r28 = r27.toString();     // Catch: Throwable -> L72
        ((HashMap) this.b).remove(r28);     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        throw th;
    }

    public final void o(Scene r2, com.ss.android.lark.media.a r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2);
        if (r3 == null) goto L5;
        int r4 = r3.hashCode();
    L6:
        r0.append(r4);
        String r5 = r0.toString();
        ((HashMap) this.a).remove(r5);
        return;
    L5:
        r4 = 0;
        goto L6
    }

    public final void f(Scene r3, boolean r4, com.ss.android.lark.media.a r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r3);
        r0.append(r5.hashCode());
        String r6 = r0.toString();
        if (r4 == true) goto L17;
        ArrayList<String> r7 = this.e;
        if (r7 == null) goto L14;
        ArrayList r1 = new ArrayList();
        r1.addAll(r7);
        ((HashMap) this.k).put(r6, r1);
        ArrayList r2 = new ArrayList();
        r2.addAll(this.h);
        ((EnumMap) this.n).put(r3, r2);
        MediaType.a r8 = MediaType.Companion;
        Iterator<String> r9 = r7.iterator();
    L8:
        if (r9.hasNext() == false) goto L14;
        String r10 = r9.next();
        WeakReference r11 = (WeakReference) ((HashMap) this.a).get(r10);
        if (r11 == null) goto L8;
        com.ss.android.lark.media.a r12 = (com.ss.android.lark.media.a) r11.get();
        if (r12 == null) goto L8;
        r12.b(r3, MediaType.Audio_Play);
    L14:
        this.e.clear();
        ArrayList<Scene> r13 = this.h;
        if (r13 == null) goto L17;
        r13.clear();
    L17:
        this.e.add(r6);
        ArrayList<Scene> r14 = this.h;
        if (r14 == null) goto L28;
        r14.add(r3);
        return;
    }

    public final void l(Scene r18, boolean r19, com.ss.android.lark.media.a r20, boolean r21) {
        Intrinsics.checkNotNullParameter(r18, "scene");
        Intrinsics.checkNotNullParameter(r20, "listener");
        monitor-enter(this);
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L139
        r4.append(r18);     // Catch: Throwable -> L139
        r4.append(r20.hashCode());     // Catch: Throwable -> L139
        String r5 = r4.toString();     // Catch: Throwable -> L139
        Map<String, WeakReference<com.ss.android.lark.media.a>> r6 = this.a;     // Catch: Throwable -> L139
        HashMap r7 = (HashMap) r6;     // Catch: Throwable -> L139
        r7.put(r5, new WeakReference(r20));     // Catch: Throwable -> L139
        SceneMediaConfig r8 = this.q.get(r18);     // Catch: Throwable -> L139
        Ref.BooleanRef r9 = new Ref.BooleanRef();     // Catch: Throwable -> L139
        r9.element = true;     // Catch: Throwable -> L139
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L139
        r10.append(r18);     // Catch: Throwable -> L139
        r10.append(r20.hashCode());     // Catch: Throwable -> L139
        String r11 = r10.toString();     // Catch: Throwable -> L139
        ((HashMap) this.b).put(r11, r18);     // Catch: Throwable -> L139
        int r12 = 3;
        if (r8 == null) goto L40;
        ArrayList<MediaConfig> r13 = r8.getMediaConfig();     // Catch: Throwable -> L139
        if (r13 == null) goto L40;
        Iterator<MediaConfig> r14 = r13.iterator();     // Catch: Throwable -> L139
    L10:
        if (r14.hasNext() == false) goto L40;
        MediaType r15 = r14.next().getType();     // Catch: Throwable -> L139
        int r16 = b.a[r15.ordinal()];     // Catch: Throwable -> L139
        if (r16 != 1) goto L13;
        if (r21 == false) goto L10;
        if (r9.element == true) goto L35;
    L37:
        boolean r17 = false;
    L38:
        r9.element = r17;     // Catch: Throwable -> L139
        goto L10
    L35:
        if (TextUtils.equals(r11, this.c) == false) goto L37;
        r17 = true;
        goto L38
    L13:
        if (r16 != 2) goto L14;
        if (r9.element == true) goto L27;
    L29:
        boolean r110 = false;
    L30:
        r9.element = r110;     // Catch: Throwable -> L139
        goto L10
    L27:
        if (TextUtils.equals(r11, this.d) == false) goto L29;
        r110 = true;
        goto L30
    L14:
        if (r16 != 3) goto L23;
        if (r9.element == true) goto L18;
    L20:
        boolean r111 = false;
    L21:
        r9.element = r111;     // Catch: Throwable -> L139
        goto L10
    L18:
        if (this.e.contains(r11) == false) goto L20;
        r111 = true;
        goto L21
    L23:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L139
    L40:
        if (r9.element == false) goto L44;
        r20.onSuccess();     // Catch: Throwable -> L139
        monitor-exit(this);
        return;
    L44:
        if (r8 == null) goto L137;
        ArrayList<MediaConfig> r22 = r8.getMediaConfig();     // Catch: Throwable -> L139
        if (r22 == null) goto L137;
        Iterator<MediaConfig> r23 = r22.iterator();     // Catch: Throwable -> L139
        boolean r112 = r19;
        boolean r24 = false;
        boolean r113 = false;
        boolean r114 = false;
    L49:
        if (r23.hasNext() == false) goto L130;
        MediaConfig r115 = r23.next();     // Catch: Throwable -> L139
        MediaType r116 = r115.getType();     // Catch: Throwable -> L139
        int r117 = b.a[r116.ordinal()];     // Catch: Throwable -> L139
        if (r117 == 1) goto L120;
        if (r117 == 2) goto L100;
        if (r117 != r12) goto L98;
        if (this.e.contains(r11) == true) goto L129;
        Iterator<Scene> r118 = this.h.iterator();     // Catch: Throwable -> L139
    L59:
        if (r118.hasNext() == false) goto L93;
        Scene r119 = r118.next();     // Catch: Throwable -> L139
        if (r112 == false) goto L70;
        SceneMediaConfig r120 = this.q.get(r119);     // Catch: Throwable -> L139
        if (r120 != null) goto L65;
    L67:
        boolean r121 = false;
    L68:
        if (r121 == false) goto L70;
        r112 = true;
    L71:
        Priority r25 = b(r119, MediaType.Audio_Play);     // Catch: Throwable -> L139
        if (r25 != null) goto L74;
    L87:
        boolean r26 = true;
    L88:
        if (r26 == true) goto L59;
        r20.a(new LockError(r119, ""));     // Catch: Throwable -> L139
        o(r18, r20);     // Catch: Throwable -> L139
        monitor-exit(this);
        return;
    L74:
        if (r25.compareTo(r115.getPriority()) <= 0) goto L76;
    L77:
        if (r19 == false) goto L86;
        SceneMediaConfig r27 = this.q.get(r119);     // Catch: Throwable -> L139
        if (r27 != null) goto L81;
    L83:
        boolean r28 = false;
    L84:
        if (r28 == false) goto L86;
    L81:
        if (r27.getMixWithOthers() != true) goto L83;
        r28 = true;
    L86:
        r26 = false;
        goto L88
    L76:
        if (r25 != Priority.High) goto L87;
    L65:
        if (r120.getMixWithOthers() != true) goto L67;
        r121 = true;
    L70:
        r112 = false;
        goto L71
    L93:
        SceneMediaConfig r29 = this.q.get(r18);     // Catch: Throwable -> L139
        if (r29 == null) goto L96;
        r29.setMixWithOthers(r19);     // Catch: Throwable -> L139
    L96:
        r12 = 3;
        r114 = true;
    L129:
        r12 = 3;
        goto L49
    L98:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L139
    L100:
        if (TextUtils.equals(r11, this.d) == true) goto L129;
        Scene.a r30 = Scene.Companion;     // Catch: Throwable -> L139
        Priority r31 = b(this.g, MediaType.Audio_Record);     // Catch: Throwable -> L139
        if (r31 != null) goto L105;
    L110:
        boolean r32 = true;
    L111:
        if (r32 == true) goto L115;
        Scene r33 = this.g;     // Catch: Throwable -> L139
        if (r33 == null) goto L115;
        r20.a(new LockError(r33, ""));     // Catch: Throwable -> L139
        r113 = false;
    L116:
        if (r113 == true) goto L129;
        o(r18, r20);     // Catch: Throwable -> L139
        monitor-exit(this);
        return;
    L115:
        r113 = r32;
        goto L116
    L105:
        if (r31.compareTo(r115.getPriority()) <= 0) goto L107;
    L109:
        r32 = false;
        goto L111
    L107:
        if (r31 == Priority.High) goto L109;
    L120:
        if (r21 == false) goto L129;
        if (TextUtils.equals(r11, this.c) == true) goto L129;
        r24 = m(r115, r20);     // Catch: Throwable -> L139
        if (r24 == true) goto L129;
        o(r18, r20);     // Catch: Throwable -> L139
        monitor-exit(this);
        return;
    L130:
        if (r24 == false) goto L132;
        j(r18, r20);     // Catch: Throwable -> L139
    L132:
        if (r113 == false) goto L134;
        h(r18, r20);     // Catch: Throwable -> L139
    L134:
        if (r114 == false) goto L136;
        f(r18, r112, r20);     // Catch: Throwable -> L139
    L136:
        r20.onSuccess();     // Catch: Throwable -> L139
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L139
    L137:
        monitor-exit(this);
        return;
    L139:
        th = move-exception;
        throw th;
    }
}

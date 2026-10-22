package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageListDecorationController {
    public final Context a;
    public final List<z3b.a> b;
    public final RecyclerView c;
    public int d;
    public int e;
    public int f;
    public int g;
    public float h;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/decoration/MessageListDecorationController$Scene;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SCENE_INIT", "SCENE_BANNER", "SCENE_TAB", "SCENE_WIDGET", "SCENE_PIN", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Scene extends Enum<Scene> {
        public static final Scene SCENE_BANNER = null;
        public static final Scene SCENE_INIT = null;
        public static final Scene SCENE_PIN = null;
        public static final Scene SCENE_TAB = null;
        public static final Scene SCENE_WIDGET = null;
        public static final /* synthetic */ Scene[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<Scene> getEntries() {
            return b;
        }

        static {
            Scene r0 = new Scene("SCENE_INIT", 0, "init");
            SCENE_INIT = r0;
            Scene r1 = new Scene("SCENE_BANNER", 1, "banner");
            SCENE_BANNER = r1;
            Scene r2 = new Scene("SCENE_TAB", 2, "tab");
            SCENE_TAB = r2;
            Scene r4 = new Scene("SCENE_WIDGET", 3, "widget");
            SCENE_WIDGET = r4;
            Scene r6 = new Scene("SCENE_PIN", 4, "pin");
            SCENE_PIN = r6;
            Scene[] r8 = {r0, r1, r2, r4, r6};
            a = r8;
            b = EnumEntriesKt.enumEntries(r8);
        }

        public static Scene[] values() {
            return (Scene[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static Scene valueOf(String r1) {
            return (Scene) r27.a.a(Scene.class, r1);
        }

        public Scene(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public final Context a;
        public final RecyclerView b;
        public final List<z3b.a> c;

        public final Context getContext() {
            return this.a;
        }

        public a(Context r2, SceneCoordinateRecyclerView r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "recyclerView");
            this.a = r2;
            this.b = r3;
            this.c = new ArrayList();
        }
    }

    public static final class b {
    }

    public static final class c {
        public final Scene a;
        public final d b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "DecorationHeightChangeEvent(scene=" + this.a + ", height=" + this.b + ')';
        }

        public c(Scene r2, d r3) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            Intrinsics.checkNotNullParameter(r3, "height");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d {
        public final Integer a;
        public final Integer b;
        public final Integer c;
        public final Integer d;

        public d() {
            this(null, 15);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            Integer r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.d;
            if (r10 == null) goto L19;
            r1 = r10.hashCode();
        L19:
            return r9 + r1;
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "DecorationHeightInfo(bannerHeight=" + this.a + ", tabHeight=" + this.b + ", widgetHeight=" + this.c + ", pinHeight=" + this.d + ')';
        }

        public d(Integer r2, int r3) {
            if ((r3 & 1) == 0) goto L5;
            r2 = null;
        L5:
            this.a = r2;
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    static {
    }

    public MessageListDecorationController(a r2) {
        this.a = r2.getContext();
        this.b = r2.c;
        this.c = r2.b;
    }

    public final void a(Scene r8) {
        float r0 = ((this.d + this.e) + this.f) + this.g;
        int r1 = y9c.b.a;
        Context r2 = this.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        int r3 = y9c.a.a;
        boolean r4 = true;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.adjust_title_bar_height_in_forseti_new") == false) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == false) goto L10;
        int r6 = r2.getResources().getDimensionPixelSize(2131167840);
    L11:
        ZoomLevel6 r7 = zz7.b.d();
        float r9 = r6;
        if (r7.getLevel() <= ZoomLevel6.NORMAL.getLevel()) goto L15;
        r9 = r9 * r7.getMultiplier();
    L15:
        float r10 = r0 + r9;
        if (this.h == r10) goto L19;
        r4 = false;
    L19:
        if (r4 == true) goto L35;
        Log.i("MessageListDecoration", "trigger decoration height change by " + r8.getValue());
        Iterator r11 = ((ArrayList) this.b).iterator();
    L22:
        if (r11.hasNext() == false) goto L26;
        Object r12 = r11.next();
        if (((z3b.a) r12).isEnable() == false) goto L22;
    L27:
        z3b.a r13 = (z3b.a) r12;
        if (r13 == null) goto L30;
        r13.c(r10);
    L30:
        this.c.invalidateItemDecorations();
        this.h = r10;
        return;
    L26:
        r12 = null;
        goto L27
    L35:
        return;
    L10:
        r6 = r2.getResources().getDimensionPixelSize(2131168457);
        goto L11
    L5:
        if (ForsetiConfig.b() == false) goto L7;
        r5 = true;
        goto L8
    }
}

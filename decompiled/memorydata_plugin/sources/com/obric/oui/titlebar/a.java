package com.obric.oui.titlebar;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.SurfaceControl;
import android.view.View;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.oui.button.OButtonGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u0000 32\u00020\u0001:\b./012345BG\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\rHÆ\u0003JI\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020+J\t\u0010,\u001a\u00020-HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u00066"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBarState;", "", "bounds", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$BoundsState;", Params.CONTENT, "Lcom/obric/oui/titlebar/OFloatingTitleBarState$ContentState;", "actions", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$ActionsState;", "style", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$StyleState;", "animationState", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$AnimationState;", "interruptedOverlaySurface", "Landroid/view/SurfaceControl;", "(Lcom/obric/oui/titlebar/OFloatingTitleBarState$BoundsState;Lcom/obric/oui/titlebar/OFloatingTitleBarState$ContentState;Lcom/obric/oui/titlebar/OFloatingTitleBarState$ActionsState;Lcom/obric/oui/titlebar/OFloatingTitleBarState$StyleState;Lcom/obric/oui/titlebar/OFloatingTitleBarState$AnimationState;Landroid/view/SurfaceControl;)V", "getActions", "()Lcom/obric/oui/titlebar/OFloatingTitleBarState$ActionsState;", "getAnimationState", "()Lcom/obric/oui/titlebar/OFloatingTitleBarState$AnimationState;", "getBounds", "()Lcom/obric/oui/titlebar/OFloatingTitleBarState$BoundsState;", "getContent", "()Lcom/obric/oui/titlebar/OFloatingTitleBarState$ContentState;", "getInterruptedOverlaySurface", "()Landroid/view/SurfaceControl;", "getStyle", "()Lcom/obric/oui/titlebar/OFloatingTitleBarState$StyleState;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "resolveIconResources", "context", "Landroid/content/Context;", "toBundle", "Landroid/os/Bundle;", "toString", "", "ActionItem", "ActionKey", "ActionsState", "AnimationState", "BoundsState", "Companion", "ContentState", "StyleState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f14758a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f14759b;
    private final g c;
    private final c d;
    private final h e;
    private final d f;
    private final SurfaceControl g;

    /* JADX INFO: renamed from: com.obric.oui.titlebar.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001,B]\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003Ja\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010$\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0006HÖ\u0001J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010)\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u0010\u0010*\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006-"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBarState$ActionItem;", "", "type", "", "iconRes", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", OaidModel.KEY_ID, "tintColor", "onClickListener", "Landroid/view/View$OnClickListener;", "enabled", "", "iconResourceName", "(IILjava/lang/String;Ljava/lang/String;ILandroid/view/View$OnClickListener;ZLjava/lang/String;)V", "getEnabled", "()Z", "getIconRes", "()I", "getIconResourceName", "()Ljava/lang/String;", "getId", "getOnClickListener", "()Landroid/view/View$OnClickListener;", "getText", "getTintColor", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "withEnabled", "withIconResourceName", "withId", "withTintColor", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0783a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0784a f14760a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14761b;
        private final int c;
        private final String d;
        private final String e;
        private final int f;
        private final View.OnClickListener g;
        private final boolean h;
        private final String i;

        /* JADX INFO: renamed from: com.obric.oui.titlebar.a$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u001c\u0010\f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u001c\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBarState$ActionItem$Companion;", "", "()V", "TYPE_ICON", "", "TYPE_TEXT", "TYPE_TITLE_ARROW", "icon", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$ActionItem;", "iconRes", "onClickListener", "Landroid/view/View$OnClickListener;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "titleArrow", "title", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class C0784a {
            private C0784a() {
            }

            public /* synthetic */ C0784a(DefaultConstructorMarker r1) {
                this();
            }

            public static /* synthetic */ C0783a a(C0784a r1, int r2, View.OnClickListener r3, int r4, Object r5) {
                View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
                if ((r4 & 2) == 0) goto L6;
                r6 = null;
            L6:
                return r1.a(r2, r6);
            }

            public static /* synthetic */ C0783a a(C0784a r1, String r2, View.OnClickListener r3, int r4, Object r5) {
                View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
                if ((r4 & 2) == 0) goto L6;
                r6 = null;
            L6:
                return r1.a(r2, r6);
            }

            public static /* synthetic */ C0783a b(C0784a r1, String r2, View.OnClickListener r3, int r4, Object r5) {
                View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
                if ((r4 & 2) == 0) goto L6;
                r6 = null;
            L6:
                return r1.b(r2, r6);
            }

            @JvmStatic
            public final C0783a a(int r12, View.OnClickListener r13) {
                int r1 = 1;
                String r3 = null;
                String r4 = null;
                int r5 = 0;
                return new C0783a(r1, r12, r3, r4, r5, (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r13, View.OnClickListener.class, "com.obric.memorydata.plugin"), false, null, 192, null);
            }

            @JvmStatic
            public final C0783a a(String r12, View.OnClickListener r13) {
                View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r13, View.OnClickListener.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
                return new C0783a(2, 0, r12, null, 0, r6, false, null, 192, null);
            }

            @JvmStatic
            public final C0783a b(String r12, View.OnClickListener r13) {
                View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r13, View.OnClickListener.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r12, "title");
                return new C0783a(3, 0, r12, null, 0, r6, false, null, 192, null);
            }
        }

        static {
            f14760a = new C0784a(null);
        }

        public C0783a(int r3, int r4, String r5, String r6, int r7, View.OnClickListener r8, boolean r9, String r10) {
            View.OnClickListener r11 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r8, View.OnClickListener.class, "com.obric.memorydata.plugin");
            this.f14761b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r11;
            this.h = r9;
            this.i = r10;
        }

        public /* synthetic */ C0783a(int r9, int r10, String r11, String r12, int r13, View.OnClickListener r14, boolean r15, String r16, int r17, DefaultConstructorMarker r18) {
            View.OnClickListener r1 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r14, View.OnClickListener.class, "com.obric.memorydata.plugin");
            int r3 = 0;
            if ((r17 & 2) == 0) goto L5;
            int r2 = 0;
        L6:
            String r5 = null;
            if ((r17 & 4) == 0) goto L9;
            String r4 = null;
        L11:
            if ((r17 & 8) == 0) goto L13;
            String r6 = null;
        L15:
            if ((r17 & 16) != 0) goto L19;
            r3 = r13;
        L19:
            if ((r17 & 32) == 0) goto L22;
            r1 = null;
        L22:
            if ((r17 & 64) == 0) goto L24;
            boolean r7 = true;
        L26:
            if ((r17 & 128) != 0) goto L29;
            r5 = r16;
        L29:
            this(r9, r2, r4, r6, r3, r1, r7, r5);
            return;
        L24:
            r7 = r15;
            goto L26
        L13:
            r6 = r12;
            goto L15
        L9:
            r4 = r11;
            goto L11
        L5:
            r2 = r10;
            goto L6
        }

        public static /* synthetic */ C0783a a(C0783a r9, int r10, int r11, String r12, String r13, int r14, View.OnClickListener r15, boolean r16, String r17, int r18, Object r19) {
            View.OnClickListener r2 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, View.OnClickListener.class, "com.obric.memorydata.plugin");
            if ((r18 & 1) == 0) goto L5;
            int r3 = r9.f14761b;
        L7:
            if ((r18 & 2) == 0) goto L9;
            int r4 = r9.c;
        L11:
            if ((r18 & 4) == 0) goto L13;
            String r5 = r9.d;
        L15:
            if ((r18 & 8) == 0) goto L17;
            String r6 = r9.e;
        L19:
            if ((r18 & 16) == 0) goto L21;
            int r7 = r9.f;
        L23:
            if ((r18 & 32) == 0) goto L26;
            r2 = r9.g;
        L26:
            if ((r18 & 64) == 0) goto L28;
            boolean r8 = r9.h;
        L30:
            if ((r18 & 128) == 0) goto L32;
            String r1 = r9.i;
        L34:
            return r9.a(r3, r4, r5, r6, r7, r2, r8, r1);
        L32:
            r1 = r17;
            goto L34
        L28:
            r8 = r16;
            goto L30
        L21:
            r7 = r14;
            goto L23
        L17:
            r6 = r13;
            goto L19
        L13:
            r5 = r12;
            goto L15
        L9:
            r4 = r11;
            goto L11
        L5:
            r3 = r10;
            goto L7
        }

        public final int a() {
            return this.c;
        }

        public final C0783a a(int r12) {
            return a(this, 0, 0, null, null, r12, null, false, null, 239, null);
        }

        public final C0783a a(int r11, int r12, String r13, String r14, int r15, View.OnClickListener r16, boolean r17, String r18) {
            return new C0783a(r11, r12, r13, r14, r15, (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r16, View.OnClickListener.class, "com.obric.memorydata.plugin"), r17, r18);
        }

        public final C0783a a(String r12) {
            return a(this, 0, 0, null, r12, 0, null, false, null, 247, null);
        }

        public final C0783a a(boolean r12) {
            return a(this, 0, 0, null, null, 0, null, r12, null, 191, null);
        }

        public final C0783a b(String r12) {
            return a(this, 0, 0, null, null, 0, null, false, r12, 127, null);
        }

        public final String b() {
            return this.d;
        }

        public final String c() {
            return this.e;
        }

        public final int d() {
            return this.f;
        }

        public final View.OnClickListener e() {
            return this.g;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0783a.class) == true) goto L8;
            return false;
        L8:
            C0783a r6 = (C0783a) ZeusTransformUtils.preCheckCast(r5, C0783a.class, "com.obric.memorydata.plugin");
            if (this.f14761b == r6.f14761b) goto L12;
            return false;
        L12:
            if (this.c == r6.c) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L21;
            return false;
        L21:
            if (this.f == r6.f) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L27;
            return false;
        L27:
            if (this.h == r6.h) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final boolean f() {
            return this.h;
        }

        public final String g() {
            return this.i;
        }

        public final int getType() {
            return this.f14761b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v13, types: [int] */
        /* JADX WARN: Type inference failed for: r1v14, types: [int] */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v19 */
        public int hashCode() {
            int r0 = ((Integer.hashCode(this.f14761b) * 31) + Integer.hashCode(this.c)) * 31;
            String r1 = this.d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (((r4 + r6) * 31) + Integer.hashCode(this.f)) * 31;
            View.OnClickListener r8 = this.g;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            boolean r11 = this.h;
            ?? r12 = r11;
            if (r11 == false) goto L17;
            r12 = 1;
        L17:
            int r13 = (r10 + r12) * 31;
            String r14 = this.i;
            if (r14 == null) goto L22;
            r2 = r14.hashCode();
        L22:
            return r13 + r2;
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "ActionItem(type=" + this.f14761b + ", iconRes=" + this.c + ", text=" + this.d + ", id=" + this.e + ", tintColor=" + this.f + ", onClickListener=" + this.g + ", enabled=" + this.h + ", iconResourceName=" + this.i + ')';
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBarState$ActionKey;", "", "type", "", "iconRes", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "tintColor", OaidModel.KEY_ID, "iconResourceName", "(IILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getIconRes", "()I", "getIconResourceName", "()Ljava/lang/String;", "getId", "getText", "getTintColor", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f14762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14763b;
        private final String c;
        private final int d;
        private final String e;
        private final String f;

        public b(int r1, int r2, String r3, int r4, String r5, String r6) {
            this.f14762a = r1;
            this.f14763b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public static /* synthetic */ b a(b r4, int r5, int r6, String r7, int r8, String r9, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.f14762a;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.f14763b;
        L8:
            int r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.c;
        L11:
            String r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.d;
        L14:
            int r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.e;
        L17:
            String r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.f;
        L20:
            int r14 = r5;
            return r4.a(r14, r13, r0, r1, r2, r10);
        }

        public final int a() {
            return this.f14763b;
        }

        public final b a(int r8, int r9, String r10, int r11, String r12, String r13) {
            return new b(r8, r9, r10, r11, r12, r13);
        }

        public final String b() {
            return this.c;
        }

        public final int c() {
            return this.d;
        }

        public final String d() {
            return this.e;
        }

        public final String e() {
            return this.f;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f14762a == r6.f14762a) goto L12;
            return false;
        L12:
            if (this.f14763b == r6.f14763b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int getType() {
            return this.f14762a;
        }

        public int hashCode() {
            int r0 = ((Integer.hashCode(this.f14762a) * 31) + Integer.hashCode(this.f14763b)) * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + Integer.hashCode(this.d)) * 31;
            String r5 = this.e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.f;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "ActionKey(type=" + this.f14762a + ", iconRes=" + this.f14763b + ", text=" + this.c + ", tintColor=" + this.d + ", id=" + this.e + ", iconResourceName=" + this.f + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003JI\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J>\u0010\u001d\u001a\u00020\u001e2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBarState$ActionsState;", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$ActionItem;", "center", "subEnd", "end", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCenter", "()Ljava/util/List;", "setCenter", "(Ljava/util/List;)V", "getEnd", "setEnd", "getStart", "setStart", "getSubEnd", "setSubEnd", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "set", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<C0783a> f14764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<C0783a> f14765b;
        private List<C0783a> c;
        private List<C0783a> d;

        public c() {
            this(null, null, null, null, 15, null);
        }

        public c(List<C0783a> r3, List<C0783a> r4, List<C0783a> r5, List<C0783a> r6) {
            List<C0783a> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List<C0783a> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            List<C0783a> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            List<C0783a> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, CommonConsts.APM_INNER_EVENT_COST_START);
            Intrinsics.checkNotNullParameter(r8, "center");
            Intrinsics.checkNotNullParameter(r9, "subEnd");
            Intrinsics.checkNotNullParameter(r10, "end");
            this.f14764a = r7;
            this.f14765b = r8;
            this.c = r9;
            this.d = r10;
        }

        public /* synthetic */ c(List r2, List r3, List r4, List r5, int r6, DefaultConstructorMarker r7) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            if ((r6 & 1) == 0) goto L6;
            r8 = CollectionsKt.emptyList();
        L6:
            if ((r6 & 2) == 0) goto L9;
            r9 = CollectionsKt.emptyList();
        L9:
            if ((r6 & 4) == 0) goto L12;
            r10 = CollectionsKt.emptyList();
        L12:
            if ((r6 & 8) == 0) goto L14;
            r11 = CollectionsKt.emptyList();
        L14:
            this(r8, r9, r10, r11);
        }

        public static /* synthetic */ c a(c r1, List r2, List r3, List r4, List r5, int r6, Object r7) {
            List<C0783a> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            List<C0783a> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List<C0783a> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            List<C0783a> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            if ((r6 & 1) == 0) goto L6;
            r8 = r1.f14764a;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r9 = r1.f14765b;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r10 = r1.c;
        L12:
            if ((r6 & 8) == 0) goto L15;
            r11 = r1.d;
        L15:
            return r1.b(r8, r9, r10, r11);
        }

        public final List<C0783a> a() {
            return this.f14764a;
        }

        public final void a(List<C0783a> r3, List<C0783a> r4, List<C0783a> r5, List<C0783a> r6) {
            List<C0783a> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List<C0783a> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            List<C0783a> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            List<C0783a> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, CommonConsts.APM_INNER_EVENT_COST_START);
            Intrinsics.checkNotNullParameter(r8, "center");
            Intrinsics.checkNotNullParameter(r9, "subEnd");
            Intrinsics.checkNotNullParameter(r10, "end");
            this.f14764a = r7;
            this.f14765b = r8;
            this.c = r9;
            this.d = r10;
        }

        public final c b(List<C0783a> r2, List<C0783a> r3, List<C0783a> r4, List<C0783a> r5) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, CommonConsts.APM_INNER_EVENT_COST_START);
            Intrinsics.checkNotNullParameter(r6, "center");
            Intrinsics.checkNotNullParameter(r7, "subEnd");
            Intrinsics.checkNotNullParameter(r8, "end");
            return new c(r1, r6, r7, r8);
        }

        public final List<C0783a> b() {
            return this.f14765b;
        }

        public final List<C0783a> c() {
            return this.c;
        }

        public final List<C0783a> d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f14764a, r6.f14764a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f14765b, r6.f14765b) == true) goto L15;
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

        public int hashCode() {
            return (((((this.f14764a.hashCode() * 31) + this.f14765b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "ActionsState(start=" + this.f14764a + ", center=" + this.f14765b + ", subEnd=" + this.c + ", end=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u001e\u001a\u00020\bHÆ\u0003JV\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\nHÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006'"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBarState$AnimationState;", "", "startState", "Lcom/obric/oui/button/OButtonGroup$AnimationState;", "centerState", "subEndState", "endState", "subEndTranslationX", "", "freezeEndAreaWidth", "", "centerTranslationX", "(Lcom/obric/oui/button/OButtonGroup$AnimationState;Lcom/obric/oui/button/OButtonGroup$AnimationState;Lcom/obric/oui/button/OButtonGroup$AnimationState;Lcom/obric/oui/button/OButtonGroup$AnimationState;FLjava/lang/Integer;F)V", "getCenterState", "()Lcom/obric/oui/button/OButtonGroup$AnimationState;", "getCenterTranslationX", "()F", "getEndState", "getFreezeEndAreaWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStartState", "getSubEndState", "getSubEndTranslationX", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/obric/oui/button/OButtonGroup$AnimationState;Lcom/obric/oui/button/OButtonGroup$AnimationState;Lcom/obric/oui/button/OButtonGroup$AnimationState;Lcom/obric/oui/button/OButtonGroup$AnimationState;FLjava/lang/Integer;F)Lcom/obric/oui/titlebar/OFloatingTitleBarState$AnimationState;", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OButtonGroup.b f14766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OButtonGroup.b f14767b;
        private final OButtonGroup.b c;
        private final OButtonGroup.b d;
        private final float e;
        private final Integer f;
        private final float g;

        public d(OButtonGroup.b r2, OButtonGroup.b r3, OButtonGroup.b r4, OButtonGroup.b r5, float r6, Integer r7, float r8) {
            Intrinsics.checkNotNullParameter(r2, "startState");
            Intrinsics.checkNotNullParameter(r3, "centerState");
            Intrinsics.checkNotNullParameter(r4, "subEndState");
            Intrinsics.checkNotNullParameter(r5, "endState");
            this.f14766a = r2;
            this.f14767b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }

        public static /* synthetic */ d a(d r5, OButtonGroup.b r6, OButtonGroup.b r7, OButtonGroup.b r8, OButtonGroup.b r9, float r10, Integer r11, float r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r6 = r5.f14766a;
        L6:
            if ((r13 & 2) == 0) goto L8;
            r7 = r5.f14767b;
        L8:
            OButtonGroup.b r15 = r7;
            if ((r13 & 4) == 0) goto L11;
            r8 = r5.c;
        L11:
            OButtonGroup.b r0 = r8;
            if ((r13 & 8) == 0) goto L14;
            r9 = r5.d;
        L14:
            OButtonGroup.b r1 = r9;
            if ((r13 & 16) == 0) goto L17;
            r10 = r5.e;
        L17:
            float r2 = r10;
            if ((r13 & 32) == 0) goto L20;
            r11 = r5.f;
        L20:
            Integer r3 = r11;
            if ((r13 & 64) == 0) goto L23;
            r12 = r5.g;
        L23:
            OButtonGroup.b r16 = r6;
            return r5.a(r16, r15, r0, r1, r2, r3, r12);
        }

        public final OButtonGroup.b a() {
            return this.f14766a;
        }

        public final d a(OButtonGroup.b r9, OButtonGroup.b r10, OButtonGroup.b r11, OButtonGroup.b r12, float r13, Integer r14, float r15) {
            Intrinsics.checkNotNullParameter(r9, "startState");
            Intrinsics.checkNotNullParameter(r10, "centerState");
            Intrinsics.checkNotNullParameter(r11, "subEndState");
            Intrinsics.checkNotNullParameter(r12, "endState");
            return new d(r9, r10, r11, r12, r13, r14, r15);
        }

        public final OButtonGroup.b b() {
            return this.f14767b;
        }

        public final OButtonGroup.b c() {
            return this.c;
        }

        public final OButtonGroup.b d() {
            return this.d;
        }

        public final float e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f14766a, r6.f14766a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f14767b, r6.f14767b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(Float.valueOf(this.e), Float.valueOf(r6.e)) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(Float.valueOf(this.g), Float.valueOf(r6.g)) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final Integer f() {
            return this.f;
        }

        public final float g() {
            return this.g;
        }

        public int hashCode() {
            int r0 = ((((((((this.f14766a.hashCode() * 31) + this.f14767b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Float.hashCode(this.e)) * 31;
            Integer r1 = this.f;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + Float.hashCode(this.g);
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "AnimationState(startState=" + this.f14766a + ", centerState=" + this.f14767b + ", subEndState=" + this.c + ", endState=" + this.d + ", subEndTranslationX=" + this.e + ", freezeEndAreaWidth=" + this.f + ", centerTranslationX=" + this.g + ')';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBarState$BoundsState;", "", "width", "", "height", "screenX", "screenY", "(IIII)V", "getHeight", "()I", "getScreenX", "getScreenY", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f14768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14769b;
        private final int c;
        private final int d;

        public e() {
            this(0, 0, 0, 0, 15, null);
        }

        public e(int r1, int r2, int r3, int r4) {
            this.f14768a = r1;
            this.f14769b = r2;
            this.c = r3;
            this.d = r4;
        }

        public /* synthetic */ e(int r2, int r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = 0;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = 0;
        L14:
            this(r2, r3, r4, r5);
        }

        public static /* synthetic */ e a(e r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.f14768a;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.f14769b;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.c;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.d;
        L15:
            return r0.a(r1, r2, r3, r4);
        }

        public final int a() {
            return this.f14768a;
        }

        public final e a(int r1, int r2, int r3, int r4) {
            return new e(r1, r2, r3, r4);
        }

        public final int b() {
            return this.f14769b;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
            if (this.f14768a == r6.f14768a) goto L12;
            return false;
        L12:
            if (this.f14769b == r6.f14769b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f14768a) * 31) + Integer.hashCode(this.f14769b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
        }

        public String toString() {
            return "BoundsState(width=" + this.f14768a + ", height=" + this.f14769b + ", screenX=" + this.c + ", screenY=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0007J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(*\u00020!2\u0006\u0010*\u001a\u00020\u0004H\u0002J\u0016\u0010+\u001a\u0004\u0018\u00010,*\u00020!2\u0006\u0010*\u001a\u00020\u0004H\u0002J\f\u0010-\u001a\u00020.*\u00020!H\u0002J\u0016\u0010/\u001a\u0004\u0018\u000100*\u00020!2\u0006\u0010*\u001a\u00020\u0004H\u0002J\f\u00101\u001a\u000202*\u00020!H\u0002J\u000e\u00103\u001a\u0004\u0018\u000104*\u00020!H\u0002J\f\u00105\u001a\u000206*\u00020!H\u0002J\"\u00107\u001a\u000208*\u00020!2\u0006\u0010*\u001a\u00020\u00042\f\u00109\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J\u001c\u0010:\u001a\u000208*\u00020!2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010;\u001a\u00020,H\u0002J\u0014\u0010<\u001a\u000208*\u00020!2\u0006\u0010=\u001a\u00020.H\u0002J\u001c\u0010>\u001a\u000208*\u00020!2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010?\u001a\u000200H\u0002J\u0014\u0010@\u001a\u000208*\u00020!2\u0006\u0010A\u001a\u000202H\u0002J\u0014\u0010B\u001a\u000208*\u00020!2\u0006\u0010C\u001a\u000206H\u0002J\u0014\u0010\"\u001a\u00020)*\u00020)2\u0006\u0010$\u001a\u00020%H\u0002J\u0014\u0010D\u001a\u000200*\u0002002\u0006\u0010$\u001a\u00020%H\u0002J\u0014\u0010D\u001a\u00020E*\u00020E2\u0006\u0010$\u001a\u00020%H\u0002J\u0014\u0010D\u001a\u00020,*\u00020,2\u0006\u0010$\u001a\u00020%H\u0002J \u0010D\u001a\b\u0012\u0004\u0012\u00020)0(*\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010$\u001a\u00020%H\u0002J\f\u0010F\u001a\u00020!*\u00020GH\u0002J\u000e\u0010H\u001a\u0004\u0018\u00010G*\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBarState$Companion;", "", "()V", "KEY_ACTION_ENABLEDS_SUFFIX", "", "KEY_ACTION_ICONS_SUFFIX", "KEY_ACTION_ICON_NAMES_SUFFIX", "KEY_ACTION_IDS_SUFFIX", "KEY_ACTION_TEXTS_SUFFIX", "KEY_ACTION_TINTS_SUFFIX", "KEY_ACTION_TYPES_SUFFIX", "KEY_ANIMATION_STATE", "KEY_CENTER_ACTIONS", "KEY_CENTER_BUTTON_STYLE", "KEY_CENTER_CUSTOM_HEIGHT", "KEY_CENTER_CUSTOM_WIDTH", "KEY_CENTER_TITLE_WIDTH", "KEY_CONTENT_TOP_INSET", "KEY_END_ACTIONS", "KEY_END_BUTTON_STYLE", "KEY_HEIGHT", "KEY_INTERRUPTED_OVERLAY_SURFACE", "KEY_SCREEN_X", "KEY_SCREEN_Y", "KEY_START_ACTIONS", "KEY_START_BUTTON_STYLE", "KEY_START_TITLE_WIDTH", "KEY_SUB_END_ACTIONS", "KEY_SUB_END_BUTTON_STYLE", "KEY_WIDTH", "fromBundle", "Lcom/obric/oui/titlebar/OFloatingTitleBarState;", "bundle", "Landroid/os/Bundle;", "resolveIconResource", "", "context", "Landroid/content/Context;", "iconResourceName", "getActions", "", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$ActionItem;", "key", "getAnimationState", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$AnimationState;", "getBounds", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$BoundsState;", "getButtonGroupAnimationState", "Lcom/obric/oui/button/OButtonGroup$AnimationState;", "getContent", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$ContentState;", "getInterruptedOverlaySurface", "Landroid/view/SurfaceControl;", "getStyle", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$StyleState;", "putActions", "", "items", "putAnimationState", "animationState", "putBounds", "bounds", "putButtonGroupAnimationState", "state", "putContent", Params.CONTENT, "putStyle", "style", "resolveIconResources", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$ActionsState;", "toBundle", "Lcom/obric/oui/button/OButtonGroup$ItemAnimationState;", "toButtonGroupItemState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f {
        private f() {
        }

        public /* synthetic */ f(DefaultConstructorMarker r1) {
            this();
        }

        private final int a(Context r6, String r7) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
            boolean r1 = true;
            if (r8 != null) goto L5;
        L8:
            boolean r9 = true;
        L9:
            if (r9 == false) goto L11;
            return 0;
        L11:
            String r4 = StringsKt.substringBefore(r7, '/', "");
            String r10 = StringsKt.substringAfter(r7, '/', "");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L14;
            boolean r11 = true;
        L15:
            if (r11 == false) goto L17;
        L24:
            return 0;
        L17:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L20;
            r1 = false;
        L20:
            if (r1 == true) goto L24;
            return ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin"), r10, r4, r5.getPackageName(), "com.obric.memorydata.plugin");
        L14:
            r11 = false;
            goto L15
        L5:
            if (r8.length() == 0) goto L8;
            r9 = false;
            goto L9
        }

        private final Bundle a(OButtonGroup.d r4) {
            Object r3 = r4.a();
            if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L5;
            b r5 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
        L6:
            Bundle r0 = new Bundle();
            r0.putInt("visibility", r4.b());
            r0.putFloat("alpha", r4.c());
            r0.putFloat("scale_x", r4.d());
            r0.putFloat("scale_y", r4.e());
            if (r5 == null) goto L9;
            r0.putBoolean("has_action_key", true);
            r0.putInt("type", r5.getType());
            r0.putInt("icon_res", r5.a());
            r0.putString(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r5.b());
            r0.putInt("tint_color", r5.c());
            r0.putString(OaidModel.KEY_ID, r5.d());
            r0.putString("icon_resource_name", r5.e());
        L9:
            return r0;
        L5:
            r5 = null;
            goto L6
        }

        private final OButtonGroup.b a(OButtonGroup.b r14, Context r15) {
            Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.memorydata.plugin");
            Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r14.g(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r17 = r16.iterator();
        L4:
            if (r17.hasNext() == false) goto L18;
            OButtonGroup.d r3 = (OButtonGroup.d) ZeusTransformUtils.preCheckCast(r17.next(), OButtonGroup.d.class, "com.obric.memorydata.plugin");
            Object r2 = r3.a();
            if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L8;
            b r4 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin");
        L9:
            b r5 = r4;
            if (r5 == null) goto L16;
            if (r5.getType() != 1) goto L16;
            int r6 = a.f14758a.a(r13, r5.e());
            if (r6 == 0) goto L16;
            r3 = OButtonGroup.d.a(r3, b.a(r5, 0, r6, null, 0, null, null, 61, null), 0, 0.0f, 0.0f, 0.0f, 30, null);
        L16:
            r1.add(r3);
            goto L4
        L8:
            r4 = null;
            goto L9
        L18:
            return OButtonGroup.b.a(r14, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0, (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), 63, null);
        }

        private final C0783a a(C0783a r13, Context r14) {
            Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
            if (r13.getType() == 1) goto L5;
            return r13;
        L5:
            int r3 = a(r15, r13.g());
            if (r3 != 0) goto L8;
            return r13;
        L8:
            return C0783a.a(r13, 0, r3, null, null, 0, null, false, null, 253, null);
        }

        private final c a(c r5, Context r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            return new c(a(r5.a(), r7), a(r5.b(), r7), a(r5.c(), r7), a(r5.d(), r7));
        }

        public static final /* synthetic */ c a(f r2, c r3, Context r4) {
            return r2.a(r3, (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"));
        }

        private final d a(d r12, Context r13) {
            Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
            return d.a(r12, a(r12.a(), r14), a(r12.b(), r14), a(r12.c(), r14), a(r12.d(), r14), 0.0f, null, 0.0f, 112, null);
        }

        public static final /* synthetic */ d a(f r2, d r3, Context r4) {
            return r2.a(r3, (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"));
        }

        private final List<C0783a> a(Bundle r25, String r26) {
            int[] r2 = r25.getIntArray(Intrinsics.stringPlus(r26, "_types"));
            if (r2 == null) goto L5;
            int[] r3 = r25.getIntArray(Intrinsics.stringPlus(r26, "_icons"));
            if (r3 != null) goto L9;
            r3 = new int[r2.length];
        L9:
            String[] r4 = r25.getStringArray(Intrinsics.stringPlus(r26, "_texts"));
            if (r4 != null) goto L12;
            r4 = new String[r2.length];
        L12:
            String[] r5 = r25.getStringArray(Intrinsics.stringPlus(r26, "_ids"));
            if (r5 != null) goto L15;
            r5 = new String[r2.length];
        L15:
            int[] r6 = r25.getIntArray(Intrinsics.stringPlus(r26, "_tints"));
            if (r6 != null) goto L18;
            r6 = new int[r2.length];
        L18:
            boolean[] r7 = r25.getBooleanArray(Intrinsics.stringPlus(r26, "_enableds"));
            if (r7 != null) goto L24;
            int r8 = r2.length;
            boolean[] r10 = new boolean[r8];
            int r11 = 0;
        L21:
            if (r11 >= r8) goto L23;
            r10[r11] = true;
            r11 = r11 + 1;
            goto L21
        L23:
            r7 = r10;
        L24:
            String[] r0 = r25.getStringArray(Intrinsics.stringPlus(r26, "_icon_names"));
            if (r0 != null) goto L27;
            r0 = new String[r2.length];
        L27:
            Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r2.length), Collection.class, "com.obric.memorydata.plugin");
            int r12 = r2.length;
            int r13 = 0;
            int r14 = 0;
        L28:
            if (r13 >= r12) goto L49;
            int r15 = r2[r13];
            int r23 = r14 + 1;
            if (r14 >= 0) goto L32;
        L34:
            int r16 = 0;
        L35:
            String r17 = (String) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(r4, r14), String.class, "com.obric.memorydata.plugin");
            String r18 = (String) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(r5, r14), String.class, "com.obric.memorydata.plugin");
            if (r14 >= 0) goto L38;
        L40:
            int r19 = 0;
        L42:
            if (r14 >= 0) goto L44;
        L46:
            boolean r21 = true;
        L47:
            r1.add(new C0783a(r15, r16, r17, r18, r19, null, r21, (String) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(r0, r14), String.class, "com.obric.memorydata.plugin")));
            r13 = r13 + 1;
            r14 = r23;
            goto L28
        L44:
            if (r14 > ArraysKt.getLastIndex(r7)) goto L46;
            r21 = r7[r14];
            goto L47
        L38:
            if (r14 > ArraysKt.getLastIndex(r6)) goto L40;
            r19 = r6[r14];
            goto L42
        L32:
            if (r14 > ArraysKt.getLastIndex(r3)) goto L34;
            r16 = r3[r14];
            goto L35
        L49:
            return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        L5:
            return CollectionsKt.emptyList();
        }

        private final List<C0783a> a(List<C0783a> r4, Context r5) {
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
            Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r9 = r7.iterator();
        L4:
            if (r9.hasNext() == false) goto L7;
            C0783a r1 = (C0783a) ZeusTransformUtils.preCheckCast(r9.next(), C0783a.class, "com.obric.memorydata.plugin");
            r8.add(a.f14758a.a(r1, r6));
            goto L4
        L7:
            return (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        }

        private final void a(Bundle r2, e r3) {
            r2.putInt("width", r3.a());
            r2.putInt("height", r3.b());
            r2.putInt("screen_x", r3.c());
            r2.putInt("screen_y", r3.d());
        }

        private final void a(Bundle r2, g r3) {
            r2.putInt("start_title_width", r3.a());
            r2.putInt("center_title_width", r3.b());
            r2.putInt("center_custom_width", r3.c());
            r2.putInt("center_custom_height", r3.d());
            r2.putInt("content_top_inset", r3.e());
        }

        private final void a(Bundle r2, h r3) {
            r2.putInt("start_button_style", r3.a());
            r2.putInt("center_button_style", r3.b());
            r2.putInt("sub_end_button_style", r3.c());
            r2.putInt("end_button_style", r3.d());
        }

        private final void a(Bundle r5, String r6, OButtonGroup.b r7) {
            Bundle r4 = new Bundle();
            r4.putInt("visibility", r7.a());
            r4.putFloat("alpha", r7.b());
            r4.putFloat("scale_x", r7.c());
            r4.putFloat("scale_y", r7.d());
            r4.putFloat("group_blur", r7.e());
            r4.putInt("group_width", r7.f());
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7.g(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r9 = r8.iterator();
        L4:
            if (r9.hasNext() == false) goto L6;
            OButtonGroup.d r2 = (OButtonGroup.d) ZeusTransformUtils.preCheckCast(r9.next(), OButtonGroup.d.class, "com.obric.memorydata.plugin");
            r0.add(a.f14758a.a(r2));
            goto L4
        L6:
            r4.putParcelableArrayList("items", new ArrayList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
            Unit r10 = Unit.INSTANCE;
            r5.putBundle(r6, r4);
        }

        private final void a(Bundle r4, String r5, d r6) {
            Bundle r3 = new Bundle();
            a.f14758a.a(r3, CommonConsts.APM_INNER_EVENT_COST_START, r6.a());
            a.f14758a.a(r3, "center", r6.b());
            a.f14758a.a(r3, "sub_end", r6.c());
            a.f14758a.a(r3, "end", r6.d());
            r3.putFloat("sub_end_translation_x", r6.e());
            if (r6.f() == null) goto L5;
            boolean r0 = true;
        L6:
            r3.putBoolean("has_freeze_end_area_width", r0);
            Integer r1 = r6.f();
            if (r1 == null) goto L10;
            r3.putInt("freeze_end_area_width", ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue());
        L10:
            r3.putFloat("center_translation_x", r6.g());
            Unit r7 = Unit.INSTANCE;
            r4.putBundle(r5, r3);
            return;
        L5:
            r0 = false;
            goto L6
        }

        private final void a(Bundle r9, String r10, List<C0783a> r11) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
            String r12 = Intrinsics.stringPlus(r10, "_types");
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r3 = r1.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r2.add(Integer.valueOf(((C0783a) ZeusTransformUtils.preCheckCast(r3.next(), C0783a.class, "com.obric.memorydata.plugin")).getType()));
            goto L4
        L6:
            r9.putIntArray(r12, CollectionsKt.toIntArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
            String r13 = Intrinsics.stringPlus(r10, "_icons");
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
            Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r6 = r4.iterator();
        L8:
            if (r6.hasNext() == false) goto L10;
            r5.add(Integer.valueOf(((C0783a) ZeusTransformUtils.preCheckCast(r6.next(), C0783a.class, "com.obric.memorydata.plugin")).a()));
            goto L8
        L10:
            r9.putIntArray(r13, CollectionsKt.toIntArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
            String r14 = Intrinsics.stringPlus(r10, "_texts");
            Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
            Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r16 = r7.iterator();
        L12:
            if (r16.hasNext() == false) goto L14;
            r15.add(((C0783a) ZeusTransformUtils.preCheckCast(r16.next(), C0783a.class, "com.obric.memorydata.plugin")).b());
            goto L12
        L14:
            Object[] r17 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
            Objects.requireNonNull(r17, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            r9.putStringArray(r14, (String[]) ZeusTransformUtils.preCheckCast(r17, String[].class, "com.obric.memorydata.plugin"));
            String r18 = Intrinsics.stringPlus(r10, "_ids");
            Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
            Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r21 = r19.iterator();
        L16:
            if (r21.hasNext() == false) goto L18;
            r20.add(((C0783a) ZeusTransformUtils.preCheckCast(r21.next(), C0783a.class, "com.obric.memorydata.plugin")).c());
            goto L16
        L18:
            Object[] r22 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
            Objects.requireNonNull(r22, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            r9.putStringArray(r18, (String[]) ZeusTransformUtils.preCheckCast(r22, String[].class, "com.obric.memorydata.plugin"));
            String r110 = Intrinsics.stringPlus(r10, "_tints");
            Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
            Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r25 = r23.iterator();
        L20:
            if (r25.hasNext() == false) goto L22;
            r24.add(Integer.valueOf(((C0783a) ZeusTransformUtils.preCheckCast(r25.next(), C0783a.class, "com.obric.memorydata.plugin")).d()));
            goto L20
        L22:
            r9.putIntArray(r110, CollectionsKt.toIntArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
            String r111 = Intrinsics.stringPlus(r10, "_enableds");
            Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
            Collection r27 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r28 = r26.iterator();
        L24:
            if (r28.hasNext() == false) goto L26;
            r27.add(Boolean.valueOf(((C0783a) ZeusTransformUtils.preCheckCast(r28.next(), C0783a.class, "com.obric.memorydata.plugin")).f()));
            goto L24
        L26:
            r9.putBooleanArray(r111, CollectionsKt.toBooleanArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")));
            String r112 = Intrinsics.stringPlus(r10, "_icon_names");
            Iterable r29 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
            Collection r113 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r30 = r29.iterator();
        L28:
            if (r30.hasNext() == false) goto L30;
            r113.add(((C0783a) ZeusTransformUtils.preCheckCast(r30.next(), C0783a.class, "com.obric.memorydata.plugin")).g());
            goto L28
        L30:
            Object[] r31 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r113, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
            Objects.requireNonNull(r31, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            r9.putStringArray(r112, (String[]) ZeusTransformUtils.preCheckCast(r31, String[].class, "com.obric.memorydata.plugin"));
        }

        public static final /* synthetic */ void a(f r0, Bundle r1, e r2) {
            r0.a(r1, r2);
        }

        public static final /* synthetic */ void a(f r0, Bundle r1, g r2) {
            r0.a(r1, r2);
        }

        public static final /* synthetic */ void a(f r0, Bundle r1, h r2) {
            r0.a(r1, r2);
        }

        public static final /* synthetic */ void a(f r0, Bundle r1, String r2, d r3) {
            r0.a(r1, r2, r3);
        }

        public static final /* synthetic */ void a(f r2, Bundle r3, String r4, List r5) {
            r2.a(r3, r4, (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"));
        }

        private final d b(Bundle r10, String r11) {
            Bundle r12 = r10.getBundle(r11);
            if (r12 != null) goto L5;
            return null;
        L5:
            OButtonGroup.b r1 = c(r12, CommonConsts.APM_INNER_EVENT_COST_START);
            if (r1 != null) goto L8;
            return null;
        L8:
            OButtonGroup.b r2 = c(r12, "center");
            if (r2 != null) goto L11;
            return null;
        L11:
            OButtonGroup.b r3 = c(r12, "sub_end");
            if (r3 != null) goto L14;
            return null;
        L14:
            OButtonGroup.b r4 = c(r12, "end");
            if (r4 != null) goto L17;
            return null;
        L17:
            float r5 = r12.getFloat("sub_end_translation_x");
            if (r12.getBoolean("has_freeze_end_area_width") == false) goto L20;
            Integer r9 = Integer.valueOf(r12.getInt("freeze_end_area_width"));
        L22:
            return new d(r1, r2, r3, r4, r5, r9, r12.getFloat("center_translation_x"));
        L20:
            r9 = (Integer) ZeusTransformUtils.preCheckCast(null, Integer.class, "com.obric.memorydata.plugin");
            goto L22
        }

        private final e b(Bundle r5) {
            return new e(r5.getInt("width"), r5.getInt("height"), r5.getInt("screen_x"), r5.getInt("screen_y"));
        }

        private final OButtonGroup.b c(Bundle r10, String r11) {
            Bundle r9 = r10.getBundle(r11);
            if (r9 != null) goto L6;
            return null;
        L6:
            List r12 = (List) ZeusTransformUtils.preCheckCast(r9.getParcelableArrayList("items"), List.class, "com.obric.memorydata.plugin");
            if (r12 != null) goto L9;
            r12 = CollectionsKt.emptyList();
        L9:
            int r2 = r9.getInt("visibility");
            float r3 = r9.getFloat("alpha");
            float r4 = r9.getFloat("scale_x");
            float r5 = r9.getFloat("scale_y");
            float r6 = r9.getFloat("group_blur");
            int r7 = r9.getInt("group_width");
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
            Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r15 = r13.iterator();
        L11:
            if (r15.hasNext() == false) goto L16;
            Bundle r16 = (Bundle) ZeusTransformUtils.preCheckCast(r15.next(), Bundle.class, "com.obric.memorydata.plugin");
            f r1 = a.f14758a;
            Intrinsics.checkNotNullExpressionValue(r16, "it");
            OButtonGroup.d r17 = r1.e(r16);
            if (r17 == null) goto L11;
            r14.add(r17);
            goto L11
        L16:
            return new OButtonGroup.b(r2, r3, r4, r5, r6, r7, (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"));
        }

        private final g c(Bundle r7) {
            return new g(r7.getInt("start_title_width"), r7.getInt("center_title_width"), r7.getInt("center_custom_width"), r7.getInt("center_custom_height"), r7.getInt("content_top_inset"));
        }

        private final h d(Bundle r5) {
            return new h(r5.getInt("start_button_style"), r5.getInt("center_button_style"), r5.getInt("sub_end_button_style"), r5.getInt("end_button_style"));
        }

        private final OButtonGroup.d e(Bundle r8) {
            if (r8.getBoolean("has_action_key") == true) goto L5;
            return null;
        L5:
            return new OButtonGroup.d(new b(r8.getInt("type"), r8.getInt("icon_res"), r8.getString(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT), r8.getInt("tint_color"), r8.getString(OaidModel.KEY_ID), r8.getString("icon_resource_name")), r8.getInt("visibility"), r8.getFloat("alpha"), r8.getFloat("scale_x", 1.0f), r8.getFloat("scale_y", 1.0f));
        }

        private final SurfaceControl f(Bundle r2) {
            Parcelable r1 = r2.getParcelable("interrupted_overlay_surface");
            if (ZeusTransformUtils.instanceOf(r1, SurfaceControl.class) == true) goto L7;
            return null;
        L7:
            return (SurfaceControl) ZeusTransformUtils.preCheckCast(r1, SurfaceControl.class, "com.obric.memorydata.plugin");
        }

        @JvmStatic
        public final a a(Bundle r9) {
            Intrinsics.checkNotNullParameter(r9, "bundle");
            r9.setClassLoader(a.class.getClassLoader());
            return new a(b(r9), c(r9), new c(a(r9, "start_actions"), a(r9, "center_actions"), a(r9, "sub_end_actions"), a(r9, "end_actions")), d(r9), b(r9, "animation_state"), f(r9));
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBarState$ContentState;", "", "startTitleWidth", "", "centerTitleWidth", "centerCustomWidth", "centerCustomHeight", "contentTopInset", "(IIIII)V", "getCenterCustomHeight", "()I", "getCenterCustomWidth", "getCenterTitleWidth", "getContentTopInset", "getStartTitleWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f14770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14771b;
        private final int c;
        private final int d;
        private final int e;

        public g() {
            this(0, 0, 0, 0, 0, 31, null);
        }

        public g(int r1, int r2, int r3, int r4, int r5) {
            this.f14770a = r1;
            this.f14771b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public /* synthetic */ g(int r2, int r3, int r4, int r5, int r6, int r7, DefaultConstructorMarker r8) {
            if ((r7 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r7 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r7 & 4) == 0) goto L12;
            r4 = 0;
        L12:
            if ((r7 & 8) == 0) goto L15;
            r5 = 0;
        L15:
            if ((r7 & 16) == 0) goto L17;
            r6 = 0;
        L17:
            this(r2, r3, r4, r5, r6);
        }

        public static /* synthetic */ g a(g r3, int r4, int r5, int r6, int r7, int r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.f14770a;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.f14771b;
        L8:
            int r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.c;
        L11:
            int r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.d;
        L14:
            int r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.e;
        L17:
            int r12 = r4;
            return r3.a(r12, r11, r0, r1, r8);
        }

        public final int a() {
            return this.f14770a;
        }

        public final g a(int r7, int r8, int r9, int r10, int r11) {
            return new g(r7, r8, r9, r10, r11);
        }

        public final int b() {
            return this.f14771b;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final int e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
            if (this.f14770a == r6.f14770a) goto L12;
            return false;
        L12:
            if (this.f14771b == r6.f14771b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.f14770a) * 31) + Integer.hashCode(this.f14771b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
        }

        public String toString() {
            return "ContentState(startTitleWidth=" + this.f14770a + ", centerTitleWidth=" + this.f14771b + ", centerCustomWidth=" + this.c + ", centerCustomHeight=" + this.d + ", contentTopInset=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBarState$StyleState;", "", "startButtonStyle", "", "centerButtonStyle", "subEndButtonStyle", "endButtonStyle", "(IIII)V", "getCenterButtonStyle", "()I", "getEndButtonStyle", "getStartButtonStyle", "getSubEndButtonStyle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f14772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14773b;
        private final int c;
        private final int d;

        public h() {
            this(0, 0, 0, 0, 15, null);
        }

        public h(int r1, int r2, int r3, int r4) {
            this.f14772a = r1;
            this.f14773b = r2;
            this.c = r3;
            this.d = r4;
        }

        public /* synthetic */ h(int r2, int r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = 0;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = 0;
        L14:
            this(r2, r3, r4, r5);
        }

        public final int a() {
            return this.f14772a;
        }

        public final h a(int r1, int r2, int r3, int r4) {
            return new h(r1, r2, r3, r4);
        }

        public final int b() {
            return this.f14773b;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
            return false;
        L8:
            h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
            if (this.f14772a == r6.f14772a) goto L12;
            return false;
        L12:
            if (this.f14773b == r6.f14773b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f14772a) * 31) + Integer.hashCode(this.f14773b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
        }

        public String toString() {
            return "StyleState(startButtonStyle=" + this.f14772a + ", centerButtonStyle=" + this.f14773b + ", subEndButtonStyle=" + this.c + ", endButtonStyle=" + this.d + ')';
        }
    }

    static {
        f14758a = new f(null);
    }

    public a() {
        this(null, null, null, null, null, null, 63, null);
    }

    public a(e r2, g r3, c r4, h r5, d r6, SurfaceControl r7) {
        Intrinsics.checkNotNullParameter(r2, "bounds");
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r4, "actions");
        Intrinsics.checkNotNullParameter(r5, "style");
        this.f14759b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public /* synthetic */ a(e r12, g r13, c r14, h r15, d r16, SurfaceControl r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        e r0 = new e(0, 0, 0, 0, 15, null);
    L7:
        if ((r18 & 2) == 0) goto L9;
        g r1 = new g(0, 0, 0, 0, 0, 31, null);
    L11:
        if ((r18 & 4) == 0) goto L13;
        c r2 = new c(null, null, null, null, 15, null);
    L15:
        if ((r18 & 8) == 0) goto L17;
        h r3 = new h(0, 0, 0, 0, 15, null);
    L18:
        SurfaceControl r5 = null;
        if ((r18 & 16) == 0) goto L21;
        d r4 = null;
    L23:
        if ((r18 & 32) != 0) goto L26;
        r5 = r17;
    L26:
        this(r0, r1, r2, r3, r4, r5);
        return;
    L21:
        r4 = r16;
        goto L23
    L17:
        r3 = r15;
        goto L18
    L13:
        r2 = r14;
        goto L15
    L9:
        r1 = r13;
        goto L11
    L5:
        r0 = r12;
        goto L7
    }

    public static /* synthetic */ a a(a r4, e r5, g r6, c r7, h r8, d r9, SurfaceControl r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.f14759b;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.c;
    L8:
        g r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.d;
    L11:
        c r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.e;
    L14:
        h r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.f;
    L17:
        d r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.g;
    L20:
        e r14 = r5;
        return r4.a(r14, r13, r0, r1, r2, r10);
    }

    public final e a() {
        return this.f14759b;
    }

    public final a a(Context r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        f r0 = f14758a;
        c r5 = f.a(r0, this.d, r13);
        d r1 = this.f;
        if (r1 != null) goto L5;
        d r14 = null;
    L7:
        return a(this, null, null, r5, null, r14, null, 43, null);
    L5:
        r14 = f.a(r0, r1, r13);
        goto L7
    }

    public final a a(e r8, g r9, c r10, h r11, d r12, SurfaceControl r13) {
        Intrinsics.checkNotNullParameter(r8, "bounds");
        Intrinsics.checkNotNullParameter(r9, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r10, "actions");
        Intrinsics.checkNotNullParameter(r11, "style");
        return new a(r8, r9, r10, r11, r12, r13);
    }

    public final g b() {
        return this.c;
    }

    public final c c() {
        return this.d;
    }

    public final h d() {
        return this.e;
    }

    public final d e() {
        return this.f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f14759b, r6.f14759b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final SurfaceControl f() {
        return this.g;
    }

    public final Bundle g() {
        Bundle r0 = new Bundle();
        f r1 = f14758a;
        f.a(r1, r0, a());
        f.a(r1, r0, b());
        f.a(r1, r0, "start_actions", c().a());
        f.a(r1, r0, "center_actions", c().b());
        f.a(r1, r0, "sub_end_actions", c().c());
        f.a(r1, r0, "end_actions", c().d());
        f.a(r1, r0, d());
        d r2 = e();
        if (r2 == null) goto L6;
        f.a(r1, r0, "animation_state", r2);
    L6:
        SurfaceControl r4 = f();
        if (r4 == null) goto L10;
        r0.putParcelable("interrupted_overlay_surface", (Parcelable) ZeusTransformUtils.preCheckCast(r4, Parcelable.class, "com.obric.memorydata.plugin"));
    L10:
        return r0;
    }

    public int hashCode() {
        int r0 = ((((((this.f14759b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        d r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        SurfaceControl r5 = this.g;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "OFloatingTitleBarState(bounds=" + this.f14759b + ", content=" + this.c + ", actions=" + this.d + ", style=" + this.e + ", animationState=" + this.f + ", interruptedOverlaySurface=" + this.g + ')';
    }
}

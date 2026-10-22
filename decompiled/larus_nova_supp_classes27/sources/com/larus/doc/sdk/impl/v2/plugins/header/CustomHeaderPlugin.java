package com.larus.doc.sdk.impl.v2.plugins.header;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.document.y5;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.util.MainLooper;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0003 !\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u0015H\u0016J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001c\u0010\u001d\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u001f\u0010\u0005\u001a\u00060\u0006R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\u000b\u001a\u00060\fR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006#"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/header/CustomHeaderPlugin;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "<init>", "()V", "exitDocumentHandler", "Lcom/larus/doc/sdk/impl/v2/plugins/header/CustomHeaderPlugin$ExitDocumentHandler;", "getExitDocumentHandler", "()Lcom/larus/doc/sdk/impl/v2/plugins/header/CustomHeaderPlugin$ExitDocumentHandler;", "exitDocumentHandler$delegate", "Lkotlin/Lazy;", "setCustomHeaderHandler", "Lcom/larus/doc/sdk/impl/v2/plugins/header/CustomHeaderPlugin$SetCustomHeaderHandler;", "getSetCustomHeaderHandler", "()Lcom/larus/doc/sdk/impl/v2/plugins/header/CustomHeaderPlugin$SetCustomHeaderHandler;", "setCustomHeaderHandler$delegate", "getPluginId", "", "getBridgeHandlers", "", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onDetachFromHost", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onBackPressed", "", "Companion", "ExitDocumentHandler", "SetCustomHeaderHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomHeaderPlugin extends OfficeDocumentPlugin implements sa5.d {
    private static final String BIZ_NAVIGATION_SET_CUSTOM_HEADER_JSB = "biz.navigation.setCustomHeader";
    private static final String BIZ_UTIL_EXIT_DOCUMENT = "biz.util.exitDocument";
    public static final Companion Companion = null;
    private static final String EXIT_MENU_ID = "exit";
    private static final String TAG = "CustomHeaderPlugin";
    private final Lazy exitDocumentHandler$delegate;
    private final Lazy setCustomHeaderHandler$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/header/CustomHeaderPlugin$Companion;", "", "<init>", "()V", "TAG", "", "BIZ_UTIL_EXIT_DOCUMENT", "BIZ_NAVIGATION_SET_CUSTOM_HEADER_JSB", "EXIT_MENU_ID", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/header/CustomHeaderPlugin$ExitDocumentHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Ljava/lang/Void;", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/header/CustomHeaderPlugin;)V", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ExitDocumentHandler implements tb5.i<Void> {
        final /* synthetic */ CustomHeaderPlugin this$0;

        @Nullable
        public /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return null;
        }

        public ExitDocumentHandler(CustomHeaderPlugin r1) {
            this.this$0 = r1;
        }

        public void handle(Void r1, m r2) {
            ChameleonPluginHost r3 = this.this$0.getHost();
            if (r3 == null) goto L8;
            FragmentActivity r4 = r3.getActivity();
            if (r4 == null) goto L9;
            r4.finish();
            return;
        L9:
            return;
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            handle((Void) r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\nJ\u001c\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0003J\u001a\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0017H\u0003J\u001a\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0017H\u0002J\u001a\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0017H\u0002J\u001c\u0010#\u001a\u00020\r2\b\b\u0001\u0010$\u001a\u00020\u00172\b\b\u0002\u0010%\u001a\u00020\u0017H\u0002J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'H\u0002J \u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u0017H\u0002J\n\u0010.\u001a\u0004\u0018\u00010/H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/header/CustomHeaderPlugin$SetCustomHeaderHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData;", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/header/CustomHeaderPlugin;)V", "customHeaderView", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "initView", "", "releaseView", "onBackPressed", "", "onDestroy", "handle", "data", "callbackItemClicked", "itemId", "", "showCustomHeader", "hideCustomHeader", "handleBackground", "", "colorArgb", "handleTitle", "titleConfig", "Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$TitleConfig;", "bgColorInt", "handleLeftItem", "leftItem", "Lcom/larus/doc/sdk/impl/v2/plugins/header/SetCustomHeaderData$Item;", "titleColorInt", "handleRightItem", "rightItem", "isDarkColor", "colorInt", "threshold", "calcContrastRatio", "", "luminanceA", "luminanceB", "calcLuminance", "r", "g", "b", "buildColorStateList", "Landroid/content/res/ColorStateList;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SetCustomHeaderHandler implements tb5.i<SetCustomHeaderData> {
        private m callback;
        private NovaTitleBarEx customHeaderView;
        final /* synthetic */ CustomHeaderPlugin this$0;

        public static /* synthetic */ void a(SetCustomHeaderHandler r0, SetCustomHeaderData.Item r1, View r2) {
            handleLeftItem$lambda$20$lambda$16(r0, r1, r2);
        }

        public static /* synthetic */ double c(double r0) {
            return calcLuminance$lambda$41(r0);
        }

        private final double calcContrastRatio(double r3, double r5) {
            return (r3 + 0.05d) / (r5 + 0.05d);
        }

        private static final double calcLuminance$lambda$40(int r4) {
            return ((double) r4) / 255.0d;
        }

        private static final double calcLuminance$lambda$42(double r0, double r2) {
            return r0 * r2;
        }

        public static /* synthetic */ double d(int r2) {
            return calcLuminance$lambda$40(r2);
        }

        public static /* synthetic */ void e(SetCustomHeaderHandler r0, SetCustomHeaderData.Item r1, View r2) {
            handleRightItem$lambda$34$lambda$30(r0, r1, r2);
        }

        public static /* synthetic */ double f(double r0, double r2) {
            return calcLuminance$lambda$42(r0, r2);
        }

        public static /* synthetic */ void g(SetCustomHeaderData r0, SetCustomHeaderHandler r1) {
            handle$lambda$3(r0, r1);
        }

        public static /* synthetic */ void h(SetCustomHeaderHandler r0, SetCustomHeaderData.Item r1, View r2) {
            handleLeftItem$lambda$25$lambda$22(r0, r1, r2);
        }

        public static /* synthetic */ void i(SetCustomHeaderHandler r0, SetCustomHeaderData.Item r1, View r2) {
            handleRightItem$lambda$39$lambda$36(r0, r1, r2);
        }

        @Nullable
        public /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return null;
        }

        private final ColorStateList buildColorStateList() {
            Context r0 = CustomHeaderPlugin.access$getContext(this.this$0);
            if (r0 != null) goto L7;
            return null;
        L7:
            return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[0]}, new int[]{ContextCompat.getColor(r0, 2131105551), ContextCompat.getColor(r0, 2131105548), ContextCompat.getColor(r0, 2131106610), ContextCompat.getColor(r0, 2131105548)});
        }

        private final void hideCustomHeader() {
            FLogger.a.i(CustomHeaderPlugin.TAG, "SetCustomHeaderHandler - hideCustomHeader");
            NovaTitleBarEx r0 = this.customHeaderView;
            if (r0 == null) goto L5;
            r0.setVisibility(8);
            r0.getBinding().e.setOnClickListener(null);
            r0.getBinding().c.setOnClickListener(null);
            r0.getBinding().h.setOnClickListener(null);
            r0.getBinding().f.setOnClickListener(null);
            com.larus.office.base.service.m.d().c(false);
        L5:
            this.callback = null;
        }

        public final void initView() {
            View r0 = this.this$0.getHost().getFragment().getView();
            if (r0 == null) goto L7;
            View r1 = r0.getRootView();
            if (r1 == null) goto L7;
            NovaTitleBarEx r2 = (NovaTitleBarEx) r1.findViewById(2131369387);
        L8:
            this.customHeaderView = r2;
            FLogger.a.i(CustomHeaderPlugin.TAG, "SetCustomHeaderHandler - initView, customHeaderView: " + this.customHeaderView);
            return;
        L7:
            r2 = null;
            goto L8
        }

        public final boolean onBackPressed() {
            NovaTitleBarEx r0 = this.customHeaderView;
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L10;
            callbackItemClicked(CustomHeaderPlugin.EXIT_MENU_ID);
            return true;
        L10:
            return false;
        L5:
            if (r0.getVisibility() != 0) goto L7;
            r1 = true;
            goto L8
        }

        public final void onDestroy() {
            NovaTitleBarEx r0 = this.customHeaderView;
            if (r0 == null) goto L5;
            r0.setVisibility(8);
            r0.getBinding().e.setOnClickListener(null);
            r0.getBinding().c.setOnClickListener(null);
            r0.getBinding().h.setOnClickListener(null);
            r0.getBinding().f.setOnClickListener(null);
        L5:
            this.customHeaderView = null;
            this.callback = null;
        }

        public final void releaseView() {
            FLogger.a.i(CustomHeaderPlugin.TAG, "SetCustomHeaderHandler - releaseView");
            this.customHeaderView = null;
        }

        public SetCustomHeaderHandler(CustomHeaderPlugin r1) {
            this.this$0 = r1;
        }

        private static final double calcLuminance$lambda$41(double r3) {
            if (r3 > 0.03928d) goto L6;
            return r3 / 12.92d;
        L6:
            return Math.pow((r3 + 0.055d) / 1.055d, 2.4d);
        }

        private final void callbackItemClicked(String r4) {
            FLogger.a.i(CustomHeaderPlugin.TAG, "SetCustomHeaderHandler - callbackItemClicked, itemId: " + r4 + ", callback: " + this.callback);
            if (r4 != null) goto L5;
            return;
        L5:
            m r0 = this.callback;
            if (r0 == null) goto L9;
            JSONObject r1 = new JSONObject();
            r1.put("id", r4);
            r0.b(r1);
            return;
        }

        private final int handleBackground(String r7) {
            FLogger.a.i(CustomHeaderPlugin.TAG, "SetCustomHeaderHandler - handleBackground, colorArgb: " + r7);
            int r0 = 2131102529;
            if (r7 != null) goto L12;
        L8:
            NovaTitleBarEx r8 = this.customHeaderView;
            if (r8 == null) goto L11;
            r8.setBackgroundColor(r0);
        L11:
            return r0;
        L12:
            r0 = Color.parseColor(r7);     // Catch: Exception -> L6
        L6:
            e = move-exception;
            FLogger.a.e(CustomHeaderPlugin.TAG, "SetCustomHeaderHandler - handleBackground, parse color failed, color: " + r7 + ", e: ", e);
            goto L8
        }

        private final void showCustomHeader(SetCustomHeaderData r5) {
            FLogger.a.i(CustomHeaderPlugin.TAG, "SetCustomHeaderHandler - showCustomHeader, data: " + r5);
            SetCustomHeaderData.Item r1 = null;
            if (r5.isEmpty() == false) goto L5;
            SetCustomHeaderData r0 = r5;
        L6:
            if (r0 == null) goto L9;
            hideCustomHeader();
            return;
        L9:
            com.larus.office.base.service.m.d().c(true);
            NovaTitleBarEx r2 = this.customHeaderView;
            if (r2 == null) goto L12;
            r2.setVisibility(0);
            r2.setFocusable(true);
            r2.setClickable(true);
        L12:
            int r3 = handleTitle(r5.getTitleConfig(), handleBackground(r5.getThemeColor()));
            SetCustomHeaderData.Items r4 = r5.getItems();
            if (r4 == null) goto L17;
            List<SetCustomHeaderData.Item> r6 = r4.getLeft();
            if (r6 == null) goto L17;
            SetCustomHeaderData.Item r7 = (SetCustomHeaderData.Item) CollectionsKt.firstOrNull(r6);
        L18:
            handleLeftItem(r7, r3);
            SetCustomHeaderData.Items r8 = r5.getItems();
            if (r8 == null) goto L23;
            List<SetCustomHeaderData.Item> r9 = r8.getRight();
            if (r9 == null) goto L23;
            r1 = (SetCustomHeaderData.Item) CollectionsKt.firstOrNull(r9);
        L23:
            handleRightItem(r1, r3);
            return;
        L17:
            r7 = null;
            goto L18
        L5:
            r0 = null;
            goto L6
        }

        private static final void handle$lambda$3(SetCustomHeaderData r0, SetCustomHeaderHandler r1) {
            if (r0 == null) goto L4;
            r1.showCustomHeader(r0);
            return;
        L4:
            r1.hideCustomHeader();
        }

        private final void handleLeftItem(final SetCustomHeaderData.Item r12, int r13) {
            FLogger.a.i(CustomHeaderPlugin.TAG, "SetCustomHeaderHandler - handleLeftItem, leftItem: " + r12);
            SetCustomHeaderData.EIconRes r0 = null;
            if (r12 != null) goto L8;
            NovaTitleBarEx r14 = this.customHeaderView;
            if (r14 == null) goto L42;
            ImageView r15 = r14.getBinding().c;
            r15.setVisibility(8);
            r15.setOnClickListener(null);
            TextView r16 = r14.getBinding().e;
            r16.setVisibility(8);
            r16.setOnClickListener(null);
            return;
        L42:
            return;
        L8:
            boolean r3 = true;
            if (Intrinsics.areEqual(r12.getStyle(), "text") == false) goto L40;
            NovaTitleBarEx r1 = this.customHeaderView;
            if (r1 == null) goto L43;
            String r2 = r12.getText();
            if (r2 != null) goto L15;
            r2 = "";
        L15:
            r1.c6(r2, 2131105548, new h(this, r12));
            TextView r4 = r1.getBinding().e;
            Boolean r17 = r12.getEnable();
            if (r17 == null) goto L18;
            r3 = r17.booleanValue();
        L18:
            r4.setEnabled(r3);
            ColorStateList r18 = buildColorStateList();
            if (r18 == null) goto L21;
            r4.setTextColor(r18);
            return;
        L21:
            r4.setTextColor(r13);
            return;
        L43:
            return;
        L40:
            String r110 = r12.getId();     // Catch: Exception -> L26
            if (r110 == null) goto L28;
            r0 = SetCustomHeaderData.EIconRes.valueOf(r110);     // Catch: Exception -> L26
        L28:
            if (r0 == null) goto L30;
            int r5 = r0.getImgResId();
        L31:
            NovaTitleBarEx r111 = this.customHeaderView;
            if (r111 == null) goto L46;
            NovaTitleBarEx.b6(r111, r5, false, ImageView.ScaleType.CENTER_INSIDE, null, new i(this, r12), 8);
            ImageView r112 = r111.getBinding().c;
            Boolean r113 = r12.getEnable();
            if (r113 == null) goto L36;
            r3 = r113.booleanValue();
        L36:
            r112.setEnabled(r3);
            ColorStateList r114 = buildColorStateList();
            if (r114 == null) goto L47;
            r112.setImageTintList(r114);
            return;
        L47:
            return;
        L46:
            return;
        L30:
            r5 = 2131232590;
        L26:
            e = move-exception;
            FLogger.a.e(CustomHeaderPlugin.TAG, e.getMessage());
            goto L28
        }

        private final void handleRightItem(final SetCustomHeaderData.Item r10, int r11) {
            FLogger.a.i(CustomHeaderPlugin.TAG, "SetCustomHeaderHandler - handleRightItem, rightItem: " + r10);
            SetCustomHeaderData.EIconRes r0 = null;
            if (r10 != null) goto L8;
            NovaTitleBarEx r12 = this.customHeaderView;
            if (r12 == null) goto L37;
            ImageView r13 = r12.getBinding().f;
            r13.setVisibility(8);
            r13.setOnClickListener(null);
            TextView r14 = r12.getBinding().h;
            r14.setVisibility(8);
            r14.setOnClickListener(null);
            return;
        L37:
            return;
        L8:
            boolean r2 = true;
            if (Intrinsics.areEqual(r10.getStyle(), "text") == false) goto L22;
            NovaTitleBarEx r1 = this.customHeaderView;
            if (r1 == null) goto L38;
            String r3 = r10.getText();
            if (r3 != null) goto L15;
            r3 = "";
        L15:
            r1.n6(r3, 2131105548, new c(this, r10));
            TextView r4 = r1.getBinding().h;
            Boolean r15 = r10.getEnable();
            if (r15 == null) goto L18;
            r2 = r15.booleanValue();
        L18:
            r4.setEnabled(r2);
            ColorStateList r16 = buildColorStateList();
            if (r16 == null) goto L21;
            r4.setTextColor(r16);
            return;
        L21:
            r4.setTextColor(r11);
            return;
        L38:
            return;
        L22:
            String r17 = r10.getId();
            if (r17 == null) goto L25;
            r0 = SetCustomHeaderData.EIconRes.valueOf(r17);
        L25:
            if (r0 == null) goto L27;
            int r5 = r0.getImgResId();
        L28:
            NovaTitleBarEx r18 = this.customHeaderView;
            if (r18 == null) goto L41;
            NovaTitleBarEx.i6(r18, r5, ImageView.ScaleType.CENTER_INSIDE, null, new d(this, r10), 8);
            ImageView r110 = r18.getBinding().f;
            Boolean r111 = r10.getEnable();
            if (r111 == null) goto L33;
            r2 = r111.booleanValue();
        L33:
            r110.setEnabled(r2);
            ColorStateList r112 = buildColorStateList();
            if (r112 == null) goto L42;
            r110.setImageTintList(r112);
            return;
        L42:
            return;
        L41:
            return;
        L27:
            r5 = 2131232590;
            goto L28
        }

        private final int handleTitle(SetCustomHeaderData.TitleConfig r5, int r6) {
            FLogger.a.i(CustomHeaderPlugin.TAG, "SetCustomHeaderHandler - handleTitle, titleConfig: " + r5);
            if (r5 != null) goto L9;
            NovaTitleBarEx r7 = this.customHeaderView;
            if (r7 == null) goto L24;
            r7.getBinding().j.setVisibility(8);
            return -16777216;
        L24:
            return -16777216;
        L9:
            String r8 = r5.getTitle();
            if (r8 != null) goto L13;
            r8 = "";
        L13:
            if (isDarkColor$default(this, r6, 0, 2, null) == false) goto L15;
            int r9 = 2131103298;
        L16:
            NovaTitleBarEx r1 = this.customHeaderView;
            if (r1 == null) goto L19;
            r1.getBinding().j.setVisibility(0);
            r1.V5(r8, Integer.valueOf(r9), null);
        L19:
            Context r10 = CustomHeaderPlugin.access$getContext(this.this$0);
            if (r10 != null) goto L23;
            r10 = AppHost.a.getApplication();
        L23:
            return ContextCompat.getColor(r10, r9);
        L15:
            r9 = 2131103292;
            goto L16
        }

        private final boolean isDarkColor(int r5, int r6) {
            if (r6 >= calcContrastRatio(calcLuminance(255, 255, 255), calcLuminance(Color.red(r5), Color.green(r5), Color.blue(r5)))) goto L5;
            return true;
        L5:
            return false;
        }

        public void handle(final SetCustomHeaderData r4, m r5) {
            FLogger.a.i(CustomHeaderPlugin.TAG, "SetCustomHeaderHandler - handle, data: " + r4 + ", callback: " + r5);
            this.callback = r5;
            MainLooper.runOnMainThread(new j(r4, this));
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            handle((SetCustomHeaderData) r1, r2);
        }

        private final double calcLuminance(int r6, int r7, int r8) {
            return SequencesKt.sumOfDouble(SequencesKt.zip(SequencesKt.map(SequencesKt.map(SequencesKt.sequenceOf(new Integer[]{Integer.valueOf(r6), Integer.valueOf(r7), Integer.valueOf(r8)}), new e()), new f()), SequencesKt.sequenceOf(new Double[]{Double.valueOf(0.2126d), Double.valueOf(0.7152d), Double.valueOf(0.0722d)}), new g()));
        }

        private static final void handleLeftItem$lambda$20$lambda$16(SetCustomHeaderHandler r0, SetCustomHeaderData.Item r1, View r2) {
            r0.callbackItemClicked(r1.getId());
        }

        private static final void handleLeftItem$lambda$25$lambda$22(SetCustomHeaderHandler r0, SetCustomHeaderData.Item r1, View r2) {
            r0.callbackItemClicked(r1.getId());
        }

        private static final void handleRightItem$lambda$34$lambda$30(SetCustomHeaderHandler r0, SetCustomHeaderData.Item r1, View r2) {
            r0.callbackItemClicked(r1.getId());
        }

        private static final void handleRightItem$lambda$39$lambda$36(SetCustomHeaderHandler r0, SetCustomHeaderData.Item r1, View r2) {
            r0.callbackItemClicked(r1.getId());
        }

        public static /* synthetic */ boolean isDarkColor$default(SetCustomHeaderHandler r0, int r1, int r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = 3;
        L6:
            return r0.isDarkColor(r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ ExitDocumentHandler a(CustomHeaderPlugin r0) {
        return exitDocumentHandler_delegate$lambda$0(r0);
    }

    public static /* synthetic */ SetCustomHeaderHandler c(CustomHeaderPlugin r0) {
        return setCustomHeaderHandler_delegate$lambda$1(r0);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final ExitDocumentHandler getExitDocumentHandler() {
        return (ExitDocumentHandler) this.exitDocumentHandler$delegate.getValue();
    }

    private final SetCustomHeaderHandler getSetCustomHeaderHandler() {
        return (SetCustomHeaderHandler) this.setCustomHeaderHandler$delegate.getValue();
    }

    public String getPluginId() {
        String r0 = y5.a;
        return y5.e;
    }

    public boolean onBackPressed() {
        FLogger.a.i(TAG, "onBackPressed");
        return getSetCustomHeaderHandler().onBackPressed();
    }

    public CustomHeaderPlugin() {
        this.exitDocumentHandler$delegate = LazyKt.lazy(new a(this));
        this.setCustomHeaderHandler$delegate = LazyKt.lazy(new b(this));
    }

    public static final /* synthetic */ Context access$getContext(CustomHeaderPlugin r0) {
        return r0.getContext();
    }

    private static final ExitDocumentHandler exitDocumentHandler_delegate$lambda$0(CustomHeaderPlugin r1) {
        return new ExitDocumentHandler(r1);
    }

    private static final SetCustomHeaderHandler setCustomHeaderHandler_delegate$lambda$1(CustomHeaderPlugin r1) {
        return new SetCustomHeaderHandler(r1);
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_UTIL_EXIT_DOCUMENT, getExitDocumentHandler());
        r3.put(BIZ_NAVIGATION_SET_CUSTOM_HEADER_JSB, getSetCustomHeaderHandler());
    }

    public void onDetachFromHost(ChameleonPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r1);
        getSetCustomHeaderHandler().onDestroy();
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    public void onAttachToUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r1, r2);
        getSetCustomHeaderHandler().initView();
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        getSetCustomHeaderHandler().releaseView();
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}

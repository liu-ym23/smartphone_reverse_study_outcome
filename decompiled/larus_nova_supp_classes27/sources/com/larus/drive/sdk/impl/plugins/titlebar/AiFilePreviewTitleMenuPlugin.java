package com.larus.drive.sdk.impl.plugins.titlebar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.drive.preview.IDriveDownloadFilePlugin;
import com.bytedance.ee.drive.preview.IDriveThirdPartyTitleMenuPlugin;
import com.bytedance.ee.drive.preview.g;
import com.larus.utils.logger.FLogger;
import i89.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\t\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/larus/drive/sdk/impl/plugins/titlebar/AiFilePreviewTitleMenuPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "titleMenuPlugin", "Lcom/bytedance/ee/drive/preview/IDriveThirdPartyTitleMenuPlugin;", "shareAbility", "Lcom/larus/drive/sdk/impl/plugins/ability/AiFilePreviewShareAbility;", "menusUpdateListener", "com/larus/drive/sdk/impl/plugins/titlebar/AiFilePreviewTitleMenuPlugin$menusUpdateListener$1", "Lcom/larus/drive/sdk/impl/plugins/titlebar/AiFilePreviewTitleMenuPlugin$menusUpdateListener$1;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "downloadCurrentFile", "", "callback", "Lcom/bytedance/ee/drive/preview/IDriveDownloadFilePlugin$IDownloadCallback;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiFilePreviewTitleMenuPlugin extends AbsDrivePlugin {
    private static final a Companion = null;
    public static final String TAG = "AiFilePreviewTitleMenu";
    private final b menusUpdateListener;
    private d shareAbility;
    private IDriveThirdPartyTitleMenuPlugin<?> titleMenuPlugin;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements g {
        public final /* synthetic */ AiFilePreviewTitleMenuPlugin a;

        public b(AiFilePreviewTitleMenuPlugin r1) {
            this.a = r1;
        }

        public final List<MenuItem> a(List<? extends MenuItem> r11) {
            Intrinsics.checkNotNullParameter(r11, "menuItems");
            final d r0 = AiFilePreviewTitleMenuPlugin.access$getShareAbility$p(this.a);
            if (r0 != null) goto L5;
            return r11;
        L5:
            IDriveThirdPartyTitleMenuPlugin r1 = AiFilePreviewTitleMenuPlugin.access$getTitleMenuPlugin$p(this.a);
            if (r1 != null) goto L8;
            return r11;
        L8:
            List<? extends MenuItem> r2 = r11;
            Iterator<T> r3 = r2.iterator();
        L10:
            if (r3.hasNext() == false) goto L20;
            Object r4 = r3.next();
            MenuItem r7 = (MenuItem) r4;
            if (Intrinsics.areEqual(r7.getId(), "ccm_drive_share_menu") == false) goto L14;
        L17:
            boolean r8 = true;
        L18:
            if (r8 == false) goto L10;
        L21:
            MenuItem r5 = (MenuItem) r4;
            if (r5 != null) goto L25;
            FLogger.a.w(AiFilePreviewTitleMenuPlugin.TAG, "skip title menu customization, reason=share_menu_missing");
            return r11;
        L25:
            Drawable r12 = AppCompatResources.getDrawable(AiFilePreviewTitleMenuPlugin.access$getContext(this.a), c.b(2130971829, AiFilePreviewTitleMenuPlugin.access$getContext(this.a), 2131241973));
            if (r12 == null) goto L28;
            r5.setIcon(r12);
        L28:
            r5.setClickInterceptor(new com.larus.drive.sdk.impl.plugins.titlebar.a(r0));
            MenuItem r13 = r1.createDownloadMenu();
            AiFilePreviewTitleMenuPlugin r6 = this.a;
            Drawable r9 = AppCompatResources.getDrawable(AiFilePreviewTitleMenuPlugin.access$getContext(r6), c.b(2130971735, AiFilePreviewTitleMenuPlugin.access$getContext(r6), 2131241420));
            if (r9 == null) goto L31;
            r13.setIcon(r9);
        L31:
            r13.setClickInterceptor(new com.larus.drive.sdk.impl.plugins.titlebar.b(r0));
            List<MenuItem> r14 = CollectionsKt.listOf(new MenuItem[]{r13, r5});
            r0.c("download");
            r0.c("share");
            FLogger r10 = FLogger.a;
            StringBuilder r15 = new StringBuilder("update title menus, original=");
            ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
            Iterator<T> r17 = r2.iterator();
        L33:
            if (r17.hasNext() == false) goto L35;
            r16.add(((MenuItem) r17.next()).getId());
            goto L33
        L35:
            r15.append(r16);
            r15.append(", updated=");
            List<MenuItem> r18 = r14;
            ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
            Iterator<T> r21 = r18.iterator();
        L37:
            if (r21.hasNext() == false) goto L39;
            r20.add(((MenuItem) r21.next()).getId());
            goto L37
        L39:
            r15.append(r20);
            r10.i(AiFilePreviewTitleMenuPlugin.TAG, r15.toString());
            return r14;
        L14:
            if (Intrinsics.areEqual(r7.getId(), "ccm_drive_more_menu") == true) goto L17;
            r8 = false;
            goto L18
        L20:
            r4 = null;
            goto L21
        }
    }

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.plugins.titlebar.AiFilePreviewTitleMenuPlugin$onAttachToHost$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<IDriveDownloadFilePlugin.a, Boolean> {
        public AnonymousClass1(Object r8) {
            super(1, r8, AiFilePreviewTitleMenuPlugin.class, "downloadCurrentFile", "downloadCurrentFile(Lcom/bytedance/ee/drive/preview/IDriveDownloadFilePlugin$IDownloadCallback;)Z", 0);
        }

        public final Boolean invoke(IDriveDownloadFilePlugin.a r2) {
            return Boolean.valueOf(AiFilePreviewTitleMenuPlugin.access$downloadCurrentFile((AiFilePreviewTitleMenuPlugin) ((CallableReference) this).receiver, r2));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((IDriveDownloadFilePlugin.a) r1);
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public AiFilePreviewTitleMenuPlugin() {
        this.menusUpdateListener = new b(this);
    }

    public static final /* synthetic */ Context access$getContext(AiFilePreviewTitleMenuPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ d access$getShareAbility$p(AiFilePreviewTitleMenuPlugin r0) {
        return r0.shareAbility;
    }

    public static final /* synthetic */ IDriveThirdPartyTitleMenuPlugin access$getTitleMenuPlugin$p(AiFilePreviewTitleMenuPlugin r0) {
        return r0.titleMenuPlugin;
    }

    private final boolean downloadCurrentFile(IDriveDownloadFilePlugin.a r3) {
        IDriveDownloadFilePlugin r0 = findPlugin(IDriveDownloadFilePlugin.class);
        if (r0 != null) goto L6;
        FLogger.a.w(TAG, "download current file unavailable, reason=download_plugin_missing");
        return false;
    L6:
        r0.downloadCurrentFile(r3);
        FLogger.a.i(TAG, "download current file requested");
        return true;
    }

    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        if (Intrinsics.areEqual(r4.c.getOpenEntity().getAppId(), "doubao_ai_msg") == true) goto L5;
        return;
    L5:
        d r5 = (d) r4.getHostAbilityOrNull(d.class);
        if (r5 != null) goto L9;
        FLogger.a.w(TAG, "skip title menu customization, reason=share_ability_missing");
        return;
    L9:
        IDriveThirdPartyTitleMenuPlugin<?> r1 = findPlugin(IDriveThirdPartyTitleMenuPlugin.class);
        if (r1 != null) goto L13;
        FLogger.a.w(TAG, "skip title menu customization, reason=title_menu_plugin_missing");
        return;
    L13:
        this.shareAbility = r5;
        this.titleMenuPlugin = r1;
        r5.h = new AnonymousClass1(this);
        r1.setUpdateListener(this.menusUpdateListener);
        FLogger.a.i(TAG, "attach title menu customization");
    }

    public void onDetachFromHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        IDriveThirdPartyTitleMenuPlugin<?> r0 = this.titleMenuPlugin;
        if (r0 == null) goto L5;
        r0.setUpdateListener(null);
    L5:
        this.titleMenuPlugin = null;
        d r1 = this.shareAbility;
        if (r1 == null) goto L8;
        r1.h = null;
    L8:
        this.shareAbility = null;
        super.onDetachFromHost(r3);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ boolean access$downloadCurrentFile(AiFilePreviewTitleMenuPlugin r0, IDriveDownloadFilePlugin.a r1) {
        return r0.downloadCurrentFile(r1);
    }
}

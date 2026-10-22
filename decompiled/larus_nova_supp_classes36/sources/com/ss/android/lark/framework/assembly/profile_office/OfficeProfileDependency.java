package com.ss.android.lark.framework.assembly.profile_office;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kza.d;
import kza.k;
import p1c.c;
import s1c.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(b.class)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010#\u001a\u00020\u0010H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020\u001aH\u0016J\b\u0010&\u001a\u00020\u001fH\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020(H\u0016J\u0012\u0010.\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u00010(H\u0016J\u0018\u00100\u001a\u00020*2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b \u0010!¨\u00066"}, d2 = {"Lcom/ss/android/lark/framework/assembly/profile_office/OfficeProfileDependency;", "Lcom/ss/android/lark/profile_office/dependency/IOfficeProfileDependency;", "<init>", "()V", "openFeishuGalleryPreviewDependency", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/IOpenFeishuGalleryPreviewDependency;", "getOpenFeishuGalleryPreviewDependency", "()Lcom/ss/android/lark/biz/officesdk/im/mediapreview/IOpenFeishuGalleryPreviewDependency;", "openFeishuGalleryPreviewDependency$delegate", "Lkotlin/Lazy;", "imApi", "Lcom/ss/android/lark/biz/im/api/IIMApi;", "getImApi", "()Lcom/ss/android/lark/biz/im/api/IIMApi;", "imApi$delegate", "contactDep", "Lcom/ss/android/lark/profile_office/dependency/IOfficeContactDependency;", "getContactDep", "()Lcom/ss/android/lark/profile_office/dependency/IOfficeContactDependency;", "contactDep$delegate", "chatDep", "Lcom/ss/android/lark/profile/core/dependency/IBaseChatDependency;", "getChatDep", "()Lcom/ss/android/lark/profile/core/dependency/IBaseChatDependency;", "chatDep$delegate", "pushDep", "Lcom/ss/android/lark/profile/core/dependency/IBasePushDependency;", "getPushDep", "()Lcom/ss/android/lark/profile/core/dependency/IBasePushDependency;", "pushDep$delegate", "phoneDep", "Lcom/ss/android/lark/profile/core/dependency/IBasePhoneDependency;", "getPhoneDep", "()Lcom/ss/android/lark/profile/core/dependency/IBasePhoneDependency;", "phoneDep$delegate", "getContactDependency", "getChatDependency", "getPushDependency", "getPhoneDependency", "getReportHost", "", "openUrlV2", "", "context", "Landroid/content/Context;", "url", "peakFeedCard", "chatterId", "openAvatarPreview", "request", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/OpenFeishuAvatarPreviewRequest;", "from", "Landroidx/fragment/app/FragmentActivity;", "Companion", "profile-assembly-office_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OfficeProfileDependency implements b {
    public static final a Companion = null;
    private static final String TAG = "OfficeProfileDependency";
    private final Lazy chatDep$delegate;
    private final Lazy contactDep$delegate;
    private final Lazy imApi$delegate;
    private final Lazy openFeishuGalleryPreviewDependency$delegate;
    private final Lazy phoneDep$delegate;
    private final Lazy pushDep$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final p1c.a getChatDep() {
        return (p1c.a) this.chatDep$delegate.getValue();
    }

    private final s1c.a getContactDep() {
        return (s1c.a) this.contactDep$delegate.getValue();
    }

    private final IIMApi getImApi() {
        return (IIMApi) this.imApi$delegate.getValue();
    }

    private final d getOpenFeishuGalleryPreviewDependency() {
        return (d) this.openFeishuGalleryPreviewDependency$delegate.getValue();
    }

    private final c getPhoneDep() {
        return (c) this.phoneDep$delegate.getValue();
    }

    private final p1c.d getPushDep() {
        return (p1c.d) this.pushDep$delegate.getValue();
    }

    public OfficeProfileDependency() {
        this.openFeishuGalleryPreviewDependency$delegate = LazyKt.lazy(OfficeProfileDependency$openFeishuGalleryPreviewDependency$2.INSTANCE);
        this.imApi$delegate = LazyKt.lazy(OfficeProfileDependency$imApi$2.INSTANCE);
        this.contactDep$delegate = LazyKt.lazy(OfficeProfileDependency$contactDep$2.INSTANCE);
        this.chatDep$delegate = LazyKt.lazy(new OfficeProfileDependency$chatDep$2(this));
        this.pushDep$delegate = LazyKt.lazy(new OfficeProfileDependency$pushDep$2(this));
        this.phoneDep$delegate = LazyKt.lazy(OfficeProfileDependency$phoneDep$2.INSTANCE);
    }

    public p1c.a getChatDependency() {
        return getChatDep();
    }

    public /* bridge */ /* synthetic */ p1c.b getContactDependency() {
        return m669getContactDependency();
    }

    public c getPhoneDependency() {
        return getPhoneDep();
    }

    public p1c.d getPushDependency() {
        return getPushDep();
    }

    public String getReportHost() {
        return jcb.b.c().a("tns_report");
    }

    /* JADX INFO: renamed from: getContactDependency, reason: collision with other method in class */
    public s1c.a m669getContactDependency() {
        return getContactDep();
    }

    public static final /* synthetic */ IIMApi access$getImApi(OfficeProfileDependency r0) {
        return r0.getImApi();
    }

    public void peakFeedCard(String r2) {
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r0 == null) goto L6;
        r0.peakFeedCard(r2);
        return;
    }

    public void openAvatarPreview(k r2, FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "from");
        getOpenFeishuGalleryPreviewDependency().openAvatarPreview(r2, r3);
    }

    public void openUrlV2(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "url");
        com.ss.android.lark.router.c.b(r2, r3);
    }
}

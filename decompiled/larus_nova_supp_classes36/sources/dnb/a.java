package dnb;

import android.app.Activity;
import android.content.Context;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.biz.im.api.param.IMConstants;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.keyboard.plugin.tool.at.KeyboardAtModule;
import com.ss.android.lark.keyboard.plugin.tool.face.KeyboardEmojiModule;
import com.ss.android.lark.keyboard.plugin.tool.photo.KeyboardPhotoModule;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import com.ss.android.lark.utils.ApiUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pmb.d;
import yob.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a implements KeyboardAtModule.a, KeyboardEmojiModule.a, KeyboardPhotoModule.a, KeyboardVoiceModule.a {

    /* JADX INFO: renamed from: dnb.a$a, reason: collision with other inner class name */
    public static final class C0252a implements KeyboardVoiceModule.c {
        public C0252a() {
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.c
        public final void a(Context r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "chatterId");
            d r4 = nmb.a.a().getCoreDependency();
            Chatter.ChatterType r5 = Chatter.ChatterType.UNKNOWN;
            new ContactSource();
            r4.d();
        }
    }

    public a() {
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.a
    public IMConstants.NetworkLevel getCurNetWorkLevel() {
        List r0 = com.ss.android.lark.rustinfrabridge.netstate.impl.d.a;
        com.ss.android.lark.rustinfrabridge.netstate.impl.d.b.a.getClass();
        Object r1 = LarkNetworkLevelManager.d;
        return IMConstants.NetworkLevel.forNumber(LarkNetworkLevelManager.a.a().getCurNetWorkLevel().getValue());
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.face.KeyboardEmojiModule.a, com.ss.android.lark.keyboard.plugin.tool.photo.KeyboardPhotoModule.a
    public int getFileUploadAuthorizatedDenyCode() {
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getFileUploadAuthorizatedDenyCode();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.face.KeyboardEmojiModule.a, com.ss.android.lark.keyboard.plugin.tool.photo.KeyboardPhotoModule.a
    public int getFileUploadAuthorizatedDenyCodeByFilePolicy() {
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r0 != null) goto L7;
        return 321001;
    L7:
        return r0.getFileUploadDenyCodeByFilePolicy();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.a
    public KeyboardVoiceModule.c getProfileDependency() {
        return new C0252a();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.a
    public KeyboardVoiceModule.d getVcDependency() {
        int r0 = nmb.b.a;
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Boolean.class) == false) goto L6;
        Object r1 = Boolean.FALSE;
    L33:
        if (r1 == null) goto L37;
        return (KeyboardVoiceModule.d) r1;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.IVcDependency");
    L6:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Byte.class) == false) goto L9;
        r1 = (byte) 0;
        goto L33
    L9:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Short.class) == false) goto L12;
        r1 = (short) 0;
        goto L33
    L12:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Integer.class) == false) goto L15;
        r1 = 0;
        goto L33
    L15:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Long.class) == false) goto L18;
        r1 = 0L;
        goto L33
    L18:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Float.class) == false) goto L21;
        r1 = Float.valueOf(0.0f);
        goto L33
    L21:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Double.class) == false) goto L24;
        r1 = Double.valueOf(0.0d);
        goto L33
    L24:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Character.class) == false) goto L27;
        r1 = (char) 0;
        goto L33
    L27:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, ArrayList.class) == false) goto L30;
        r1 = CollectionsKt.emptyList();
        goto L33
    L30:
        if (Intrinsics.areEqual(KeyboardVoiceModule.d.class, Unit.class) == false) goto L32;
        r1 = Unit.INSTANCE;
        goto L33
    L32:
        r1 = nmb.b.a(KeyboardVoiceModule.d.class);
        goto L33
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.a
    public Locale getCurrentLocale() {
        e.a().getClass();
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        return com.ss.android.lark.language.service.impl.a.b.a.getCacheLanguageSetting();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.KeyboardPhotoModule.a
    public int getUnifiedStorageLimitErrorCode() {
        return owa.a.d().getUnifiedStorageLimitErrorCode();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.face.KeyboardEmojiModule.a
    public String getUploadAuthorizationTip() {
        return owa.a.b().a();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.a
    public boolean isEn() {
        e.a().getClass();
        return com.ss.android.lark.language.service.impl.c.a.a.b();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.a
    public boolean isZh() {
        e.a().getClass();
        com.ss.android.lark.language.service.impl.c r0 = com.ss.android.lark.language.service.impl.c.a.a;
        if (r0.c() == false) goto L5;
    L10:
        return true;
    L5:
        if (r0.d() == true) goto L10;
        if (r0.e() == true) goto L10;
        return false;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.a
    public boolean isCurrentFeatureEnable(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        return FeatureGatingModule.getFeatureGatingService().isCurrentEnable(r2);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.at.KeyboardAtModule.a, com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule.a
    public boolean isFeatureGatingEnable(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        return FeatureGatingModule.getFeatureGatingService().isEnable(r2);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.KeyboardPhotoModule.a
    public boolean isHitStorageQuotaLimit(int r2) {
        return owa.a.d().isHitStorageQuotaLimit(r2);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.KeyboardPhotoModule.a
    public void showUnifiedStorageLimitCTADialog(Activity r2) {
        owa.a.d().showUnifiedStorageLimitCTADialog(r2);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.face.KeyboardEmojiModule.a, com.ss.android.lark.keyboard.plugin.tool.photo.KeyboardPhotoModule.a
    public void onAuthorizatedDeny(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        owa.a.b().b(r2, r3);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.photo.KeyboardPhotoModule.a
    public boolean showQuotaLimitDialog(Activity r2, int r3) {
        return owa.a.d().showQuotaLimitDialog(r2, r3);
    }
}

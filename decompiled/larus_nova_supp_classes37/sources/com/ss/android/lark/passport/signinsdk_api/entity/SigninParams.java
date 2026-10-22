package com.ss.android.lark.passport.signinsdk_api.entity;

import java.io.Serializable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class SigninParams implements Serializable {
    public static final SigninParams DEFAULT = null;
    private boolean clearTask;
    private int[] enterAnimation;
    private int[] exitAnimation;
    private boolean fromGuide;

    @Nullable
    private LoginFromSource fromSource;
    private boolean isInWipeOut;
    private boolean isLogoutSettingDeepErase;
    private boolean isRegister;
    private boolean showCloseIcon;
    private boolean showDefaultAnimation;
    private boolean showLanguageSwitcher;
    private boolean showLoginBackIcon;
    private boolean skipOneKeyAuth;

    @Nullable
    private String wipeDescription;

    public static final enum LoginFromSource extends Enum<LoginFromSource> {
        public static final LoginFromSource KNOWLEDGE_AI = null;
        public static final LoginFromSource MEMPOPE = null;
        public static final String TAG_LOGIN_FROM_SOURCE = "tag_login_from_source";
        public static final /* synthetic */ LoginFromSource[] a = null;
        public final int source;

        static {
            LoginFromSource r0 = new LoginFromSource("KNOWLEDGE_AI", 0, 9);
            KNOWLEDGE_AI = r0;
            LoginFromSource r1 = new LoginFromSource("MEMPOPE", 1, 11);
            MEMPOPE = r1;
            a = new LoginFromSource[]{r0, r1};
        }

        public static LoginFromSource[] values() {
            return (LoginFromSource[]) a.clone();
        }

        public static LoginFromSource valueOf(String r1) {
            return (LoginFromSource) r27.a.a(LoginFromSource.class, r1);
        }

        public LoginFromSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.source = r3;
        }
    }

    public static class a {
        public final SigninParams a;

        public a() {
            this.a = new SigninParams();
        }
    }

    public static a newBuilder() {
        a r0 = new a();
        if (com.ss.android.lark.passport.a.b() == false) goto L5;
        LoginFromSource r1 = LoginFromSource.MEMPOPE;
        access$1102(r0.a, r1);
    L5:
        return r0;
    }

    static {
        DEFAULT = access$1500(newBuilder().a);
    }

    public SigninParams() {
        this.isRegister = false;
        this.clearTask = false;
        this.showLoginBackIcon = false;
        this.showCloseIcon = false;
        this.showLanguageSwitcher = true;
        this.fromGuide = false;
        this.skipOneKeyAuth = false;
        this.showDefaultAnimation = false;
        this.isLogoutSettingDeepErase = false;
        this.wipeDescription = null;
        this.isInWipeOut = false;
        this.fromSource = null;
    }

    public a buildUpon() {
        a r0 = newBuilder();
        boolean r1 = this.isRegister;
        access$102(r0.a, r1);
        boolean r2 = this.clearTask;
        access$202(r0.a, r2);
        boolean r3 = this.showLoginBackIcon;
        access$402(r0.a, r3);
        boolean r4 = this.showCloseIcon;
        access$1002(r0.a, r4);
        boolean r5 = this.showLanguageSwitcher;
        access$702(r0.a, r5);
        boolean r6 = this.fromGuide;
        access$302(r0.a, r6);
        boolean r7 = this.skipOneKeyAuth;
        access$502(r0.a, r7);
        boolean r8 = this.showDefaultAnimation;
        access$602(r0.a, r8);
        int[] r9 = this.enterAnimation;
        access$802(r0.a, r9);
        int[] r10 = this.exitAnimation;
        access$902(r0.a, r10);
        LoginFromSource r11 = this.fromSource;
        access$1102(r0.a, r11);
        boolean r12 = this.isLogoutSettingDeepErase;
        access$1202(r0.a, r12);
        String r13 = this.wipeDescription;
        access$1302(r0.a, r13);
        boolean r14 = this.isInWipeOut;
        access$1402(r0.a, r14);
        return r0;
    }

    public int[] getEnterAnimation() {
        return this.enterAnimation;
    }

    public int[] getExitAnimation() {
        return this.exitAnimation;
    }

    @Nullable
    public LoginFromSource getFromSource() {
        return this.fromSource;
    }

    @Nullable
    public String getWipeDescription() {
        return this.wipeDescription;
    }

    public boolean isClearTask() {
        return this.clearTask;
    }

    public boolean isFromGuide() {
        return this.fromGuide;
    }

    public boolean isInWipeOut() {
        return this.isInWipeOut;
    }

    public boolean isLogoutSettingDeepErase() {
        return this.isLogoutSettingDeepErase;
    }

    public boolean isRegister() {
        return this.isRegister;
    }

    public boolean isShowCloseIcon() {
        return this.showCloseIcon;
    }

    public boolean isShowDefaultAnimation() {
        return this.showDefaultAnimation;
    }

    public boolean isShowLanguageSwitcher() {
        return this.showLanguageSwitcher;
    }

    public boolean isShowLoginBackIcon() {
        return this.showLoginBackIcon;
    }

    public boolean isSkipOneKeyAuth() {
        return this.skipOneKeyAuth;
    }

    public static SigninParams access$1500(SigninParams r2) {
        SigninParams r0 = new SigninParams();
        r0.isRegister = r2.isRegister();
        r0.clearTask = r2.isClearTask();
        r0.fromGuide = r2.isFromGuide();
        r0.skipOneKeyAuth = r2.isSkipOneKeyAuth();
        r0.showLoginBackIcon = r2.isShowLoginBackIcon();
        r0.showDefaultAnimation = r2.isShowDefaultAnimation();
        r0.showLanguageSwitcher = r2.isShowLanguageSwitcher();
        r0.enterAnimation = r2.getEnterAnimation();
        r0.exitAnimation = r2.getExitAnimation();
        r0.showCloseIcon = r2.isShowCloseIcon();
        r0.fromSource = r2.getFromSource();
        r0.isLogoutSettingDeepErase = r2.isLogoutSettingDeepErase();
        r0.wipeDescription = r2.getWipeDescription();
        r0.isInWipeOut = r2.isInWipeOut();
        return r0;
    }

    public static /* synthetic */ boolean access$1002(SigninParams r0, boolean r1) {
        r0.showCloseIcon = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$102(SigninParams r0, boolean r1) {
        r0.isRegister = r1;
        return r1;
    }

    public static /* synthetic */ LoginFromSource access$1102(SigninParams r0, LoginFromSource r1) {
        r0.fromSource = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1202(SigninParams r0, boolean r1) {
        r0.isLogoutSettingDeepErase = r1;
        return r1;
    }

    public static /* synthetic */ String access$1302(SigninParams r0, String r1) {
        r0.wipeDescription = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1402(SigninParams r0, boolean r1) {
        r0.isInWipeOut = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$202(SigninParams r0, boolean r1) {
        r0.clearTask = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$302(SigninParams r0, boolean r1) {
        r0.fromGuide = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$402(SigninParams r0, boolean r1) {
        r0.showLoginBackIcon = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$502(SigninParams r0, boolean r1) {
        r0.skipOneKeyAuth = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$602(SigninParams r0, boolean r1) {
        r0.showDefaultAnimation = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$702(SigninParams r0, boolean r1) {
        r0.showLanguageSwitcher = r1;
        return r1;
    }

    public static /* synthetic */ int[] access$802(SigninParams r0, int[] r1) {
        r0.enterAnimation = r1;
        return r1;
    }

    public static /* synthetic */ int[] access$902(SigninParams r0, int[] r1) {
        r0.exitAnimation = r1;
        return r1;
    }
}

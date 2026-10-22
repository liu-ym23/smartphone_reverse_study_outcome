package com.ss.android.lark.chat.entity.chatter;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class AccessInfo implements o5b.a, Serializable {
    private static final long serialVersionUID = -9002720120116429273L;
    private AccessProfile phoneCallAccessProfile;
    private AccessProfile urgentAccessProfile;
    private AccessProfile videoCallAccessProfile;
    private AccessProfile voiceCallAccessProfile;

    public static class AccessProfile implements Serializable {
        private static final long serialVersionUID = 30163195286264315L;
        private InaccessibleCode inaccessibleCode;
        private boolean isAccessible;

        public AccessProfile() {
        }

        public InaccessibleCode getInaccessibleCode() {
            return this.inaccessibleCode;
        }

        public boolean isAccessible() {
            return this.isAccessible;
        }

        public static /* synthetic */ boolean access$000(AccessProfile r0) {
            return r0.isAccessible;
        }

        public static /* synthetic */ InaccessibleCode access$100(AccessProfile r0) {
            return r0.inaccessibleCode;
        }

        public void setAccessible(boolean r1) {
            this.isAccessible = r1;
        }

        public void setInaccessibleCode(InaccessibleCode r1) {
            this.inaccessibleCode = r1;
        }

        public AccessProfile(boolean r1, InaccessibleCode r2) {
            this.isAccessible = r1;
            this.inaccessibleCode = r2;
        }
    }

    public static final enum InaccessibleCode extends Enum<InaccessibleCode> {
        public static final InaccessibleCode DEFAULT = null;
        public static final InaccessibleCode EXECUTIVES = null;
        public static final /* synthetic */ InaccessibleCode[] a = null;
        private final int value;

        static {
            InaccessibleCode r0 = new InaccessibleCode("DEFAULT", 0, 0);
            DEFAULT = r0;
            InaccessibleCode r1 = new InaccessibleCode("EXECUTIVES", 1, 1);
            EXECUTIVES = r1;
            a = new InaccessibleCode[]{r0, r1};
        }

        public static InaccessibleCode[] values() {
            return (InaccessibleCode[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static InaccessibleCode fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return DEFAULT;
        L8:
            return EXECUTIVES;
        L10:
            return DEFAULT;
        }

        public static InaccessibleCode valueOf(String r1) {
            return (InaccessibleCode) r27.a.a(InaccessibleCode.class, r1);
        }

        public InaccessibleCode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public boolean isAccessPhoneCall() {
        AccessProfile r0 = this.phoneCallAccessProfile;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (AccessProfile.access$000(r0) == true) goto L8;
        return false;
    }

    public boolean isAccessVideoCall() {
        AccessProfile r0 = this.videoCallAccessProfile;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (AccessProfile.access$000(r0) == true) goto L8;
        return false;
    }

    public boolean isAccessVoiceCall() {
        AccessProfile r0 = this.voiceCallAccessProfile;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (AccessProfile.access$000(r0) == true) goto L8;
        return false;
    }

    public boolean isInaccessPhoneCallByExecutives() {
        AccessProfile r0 = this.phoneCallAccessProfile;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.isAccessible() == true) goto L9;
        if (AccessProfile.access$100(this.phoneCallAccessProfile) != InaccessibleCode.EXECUTIVES) goto L9;
        return true;
    }

    public boolean isInaccessVideoCallByExecutives() {
        AccessProfile r0 = this.videoCallAccessProfile;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.isAccessible() == true) goto L9;
        if (AccessProfile.access$100(this.videoCallAccessProfile) != InaccessibleCode.EXECUTIVES) goto L9;
        return true;
    }

    public boolean isInaccessVoiceCallByExecutives() {
        AccessProfile r0 = this.voiceCallAccessProfile;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.isAccessible() == true) goto L9;
        if (AccessProfile.access$100(this.voiceCallAccessProfile) != InaccessibleCode.EXECUTIVES) goto L9;
        return true;
    }

    public boolean isInacessUrgentByExecutives() {
        AccessProfile r0 = this.urgentAccessProfile;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.isAccessible() == true) goto L9;
        if (AccessProfile.access$100(this.urgentAccessProfile) != InaccessibleCode.EXECUTIVES) goto L9;
        return true;
    }

    public AccessInfo() {
    }

    public AccessProfile getPhoneCallAccessProfile() {
        return this.phoneCallAccessProfile;
    }

    public AccessProfile getUrgentAccessProfile() {
        return this.urgentAccessProfile;
    }

    public AccessProfile getVideoCallAccessProfile() {
        return this.videoCallAccessProfile;
    }

    public AccessProfile getVoiceCallAccessProfile() {
        return this.voiceCallAccessProfile;
    }

    public void setPhoneCallAccessProfile(AccessProfile r1) {
        this.phoneCallAccessProfile = r1;
    }

    public void setUrgentAccessProfile(AccessProfile r1) {
        this.urgentAccessProfile = r1;
    }

    public void setVideoCallAccessProfile(AccessProfile r1) {
        this.videoCallAccessProfile = r1;
    }

    public void setVoiceCallAccessProfile(AccessProfile r1) {
        this.voiceCallAccessProfile = r1;
    }
}

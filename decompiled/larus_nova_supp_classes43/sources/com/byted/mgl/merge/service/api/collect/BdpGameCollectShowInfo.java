package com.byted.mgl.merge.service.api.collect;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BdpGameCollectShowInfo {
    private String mCollectFailText;
    private String mCollectSuccessText;
    private String mCollectText;
    private boolean mIsEntranceVisible;
    private String mLoginHintText;
    private String mRemoveCollectText;
    private String mRemoveFailText;
    private String mRemoveSuccessText;

    /* JADX INFO: renamed from: com.byted.mgl.merge.service.api.collect.BdpGameCollectShowInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private String collectFailText;
        private String collectSuccessText;
        private String collectText;
        private boolean isEntranceVisible;
        private String loginHintText;
        private String removeCollectText;
        private String removeFailText;
        private String removeSuccessText;

        public Builder() {
        }

        public BdpGameCollectShowInfo build() {
            return new BdpGameCollectShowInfo(this, null);
        }

        public String getCollectFailText() {
            return this.collectFailText;
        }

        public String getCollectSuccessText() {
            return this.collectSuccessText;
        }

        public String getCollectText() {
            return this.collectText;
        }

        public String getLoginHintText() {
            return this.loginHintText;
        }

        public String getRemoveCollectText() {
            return this.removeCollectText;
        }

        public String getRemoveFailText() {
            return this.removeFailText;
        }

        public String getRemoveSuccessText() {
            return this.removeSuccessText;
        }

        public boolean isEntranceVisible() {
            return this.isEntranceVisible;
        }

        public Builder setCollectFailText(String r1) {
            this.collectFailText = r1;
            return this;
        }

        public Builder setCollectSuccessText(String r1) {
            this.collectSuccessText = r1;
            return this;
        }

        public Builder setCollectText(String r1) {
            this.collectText = r1;
            return this;
        }

        public Builder setEntranceVisible(boolean r1) {
            this.isEntranceVisible = r1;
            return this;
        }

        public Builder setLoginHintText(String r1) {
            this.loginHintText = r1;
            return this;
        }

        public Builder setRemoveCollectText(String r1) {
            this.removeCollectText = r1;
            return this;
        }

        public Builder setRemoveFailText(String r1) {
            this.removeFailText = r1;
            return this;
        }

        public Builder setRemoveSuccessText(String r1) {
            this.removeSuccessText = r1;
            return this;
        }
    }

    private BdpGameCollectShowInfo() {
    }

    public String getCollectFailText() {
        return this.mCollectFailText;
    }

    public String getCollectSuccessText() {
        return this.mCollectSuccessText;
    }

    public String getCollectText() {
        return this.mCollectText;
    }

    public String getLoginHintText() {
        return this.mLoginHintText;
    }

    public String getRemoveCollectText() {
        return this.mRemoveCollectText;
    }

    public String getRemoveFailText() {
        return this.mRemoveFailText;
    }

    public String getRemoveSuccessText() {
        return this.mRemoveSuccessText;
    }

    public boolean isEntranceVisible() {
        return this.mIsEntranceVisible;
    }

    private BdpGameCollectShowInfo(Builder r10) {
        this.mCollectText = r10.getCollectText();
        this.mRemoveCollectText = r10.getRemoveCollectText();
        this.mLoginHintText = r10.getLoginHintText();
        this.mCollectSuccessText = r10.getCollectSuccessText();
        this.mCollectFailText = r10.getCollectFailText();
        this.mRemoveSuccessText = r10.getRemoveSuccessText();
        this.mRemoveFailText = r10.getRemoveFailText();
        this.mIsEntranceVisible = r10.isEntranceVisible();
    }

    public /* synthetic */ BdpGameCollectShowInfo(Builder r1, AnonymousClass1 r10) {
        this(r1);
    }
}

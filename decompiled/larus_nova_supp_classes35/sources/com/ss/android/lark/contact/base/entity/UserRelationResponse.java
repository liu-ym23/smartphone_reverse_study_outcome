package com.ss.android.lark.contact.base.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class UserRelationResponse implements Serializable {
    private String mApplyReason;
    private boolean mBeCtrlAddContact;
    private String mContactApplicationId;
    private boolean mHasApply;
    private boolean mHasBeApply;
    private boolean mHasBeBlock;
    private boolean mHasBlock;
    private boolean mInCollaboration;
    private boolean mIsFriend;

    public static /* synthetic */ class a {
    }

    public static class b {
    }

    public UserRelationResponse() {
        this.mBeCtrlAddContact = false;
        this.mIsFriend = true;
    }

    public String getApplyReason() {
        return this.mApplyReason;
    }

    public String getContactApplicationId() {
        return this.mContactApplicationId;
    }

    public boolean isBeCtrlAddContact() {
        return this.mBeCtrlAddContact;
    }

    public boolean isFriend() {
        return this.mIsFriend;
    }

    public boolean isHasApply() {
        return this.mHasApply;
    }

    public boolean isHasBeApply() {
        return this.mHasBeApply;
    }

    public boolean isHasBeBlocked() {
        return this.mHasBeBlock;
    }

    public boolean isHasBlock() {
        return this.mHasBlock;
    }

    public boolean isInCollaboration() {
        return this.mInCollaboration;
    }

    public void setApplyReason(String r1) {
        this.mApplyReason = r1;
    }

    public void setHasApply(boolean r1) {
        this.mHasApply = r1;
    }

    public UserRelationResponse(b r1, a r2) {
        this.mBeCtrlAddContact = false;
        throw null;
    }
}

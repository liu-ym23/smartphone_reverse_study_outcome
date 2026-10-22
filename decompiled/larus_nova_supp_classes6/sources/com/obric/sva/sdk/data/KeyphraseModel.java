package com.obric.sva.sdk.data;

import com.obric.sva.sdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class KeyphraseModel implements IKeyphraseModel {
    private final String TAG;
    private String mKeyphraseFullName;
    private int mKeyphraseId;
    private String mKeyphrasePrettyName;
    private ArrayList<IUserModel> mUserList;

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public String getKeyphraseFullName() {
        return this.mKeyphraseFullName;
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public int getKeyphraseId() {
        return this.mKeyphraseId;
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public String getKeyphrasePrettyName() {
        return this.mKeyphrasePrettyName;
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public ArrayList<IUserModel> getUserList() {
        return this.mUserList;
    }

    public KeyphraseModel(String r2) {
        this.TAG = "KeyphraseModel";
        this.mKeyphraseId = -1;
        this.mUserList = new ArrayList();
        this.mKeyphraseFullName = r2;
    }

    private String maskUserIdForLog(int r4) {
        String r5 = String.valueOf(r4);
        return "****" + r5.substring(Math.max(0, r5.length() - 4));
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public IUserModel getUserModel(String r5) {
        LogUtils.d(this.TAG, "getUserModel: userName = " + r5, new Object[0]);
        if (r5 != null) goto L6;
        LogUtils.d(this.TAG, "getUserModel: invalid input param", new Object[0]);
        return null;
    L6:
        Iterator<IUserModel> r1 = this.mUserList.iterator();
    L8:
        if (r1.hasNext() == false) goto L16;
        IUserModel r2 = r1.next();
        if (r2.getUserName().equalsIgnoreCase(r5) == false) goto L8;
        return r2;
    L16:
        return null;
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public String getUserNameById(int r5) {
        Iterator<IUserModel> r0 = this.mUserList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IUserModel r1 = r0.next();
        if (r1.getUserId() != r5) goto L4;
        String r2 = r1.getUserName();
    L9:
        LogUtils.d(this.TAG, "getUserNameById: id = " + r5 + " userName = " + r2, new Object[0]);
        return r2;
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public void removeUser(String r5) {
        LogUtils.d(this.TAG, "removeUser: userName = " + r5, new Object[0]);
        if (r5 != null) goto L6;
        LogUtils.d(this.TAG, "removeUser: invalid input param", new Object[0]);
        return;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator<IUserModel> r1 = this.mUserList.iterator();
    L8:
        if (r1.hasNext() == false) goto L13;
        IUserModel r2 = r1.next();
        if (r5.equalsIgnoreCase(r2.getUserName()) == false) goto L8;
        r0.add(r2);
        goto L8
    L13:
        if (r0.isEmpty() == true) goto L21;
        this.mUserList.removeAll(r0);
        return;
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public void setKeyphraseFullName(String r1) {
        this.mKeyphraseFullName = r1;
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public void setKeyphraseId(int r5) {
        LogUtils.d(this.TAG, "setKeyphraseId: id = " + r5, new Object[0]);
        if (r5 >= (-1)) goto L6;
        LogUtils.d(this.TAG, "setKeyphraseId: invalid keyphrase id", new Object[0]);
        return;
    L6:
        this.mKeyphraseId = r5;
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public void setKeyphrasePrettyName(String r1) {
        this.mKeyphrasePrettyName = r1;
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public void addUser(String r5, int r6) {
        LogUtils.d(this.TAG, "addUser: userName = " + r5 + " userId = " + maskUserIdForLog(r6), new Object[0]);
        if (r5 != null) goto L5;
    L12:
        LogUtils.d(this.TAG, "addUser: invalid input param", new Object[0]);
        return;
    L5:
        if (r6 < (-1)) goto L12;
        IUserModel r0 = getUserModel(r5);
        if (r0 != null) goto L10;
        UserModel r1 = new UserModel(r5);
        r1.setUserId(r6);
        this.mUserList.add(r1);
        return;
    L10:
        r0.setUserId(r6);
    }
}

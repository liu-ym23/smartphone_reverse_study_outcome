package com.obric.sva.sdk.data;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IKeyphraseModel {
    public static final int INVALID_ID = -1;

    void addUser(String r1, int r2);

    String getKeyphraseFullName();

    int getKeyphraseId();

    String getKeyphrasePrettyName();

    ArrayList<IUserModel> getUserList();

    IUserModel getUserModel(String r1);

    String getUserNameById(int r1);

    void removeUser(String r1);

    void setKeyphraseFullName(String r1);

    void setKeyphraseId(int r1);

    void setKeyphrasePrettyName(String r1);
}

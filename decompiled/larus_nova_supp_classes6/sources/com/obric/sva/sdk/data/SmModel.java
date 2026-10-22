package com.obric.sva.sdk.data;

import com.obric.sva.sdk.controller.ExtendedSmMgr;
import com.obric.sva.sdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class SmModel implements ISmModel {
    public static final int NUM_OF_MAX_USERS = 3;
    public final String HEY_SNAPDRAGON;
    public final String HEY_SNAPDRAGON_3_0;
    public final String NI_HAO_XIAO_LONG;
    private final String TAG;
    protected String mSmFullFileName;
    private List<IKeyphraseModel> mSmKeyphraseList;
    private String mSmPrettyFileName;
    private String mSmPrettyKeyphrase;
    private String mSmSuffix;
    private int mSmType;
    private UUID mSmUUID;
    private ISmModel.ModelVersion mSmVersion;

    @Override // com.obric.sva.sdk.data.ISmModel
    public ArrayList<IUserModel> getAllUsers() {
        ArrayList<IUserModel> r0 = new ArrayList();
        Iterator<IKeyphraseModel> r1 = this.mSmKeyphraseList.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.addAll(r1.next().getUserList());
        goto L4
    L6:
        return r0;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public boolean isSupportExtendedOpaqueData() {
        this.mSmVersion.getVersionNumber();
        ISmModel.ModelVersion.VERSION_3_0.getVersionNumber();
        return true;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public boolean isUserTrainedSoundModel() {
        return this.mSmSuffix.endsWith(ISmModel.SUFFIX_TRAINED_SOUND_MODEL);
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public boolean canAddUser() {
        if (isUserTrainedSoundModel() == true) goto L5;
    L23:
        boolean r3 = false;
    L24:
        LogUtils.d(this.TAG, "canAddUser: canAddUser = " + r3, new Object[0]);
        return r3;
    L5:
        if (isUdkSm() == true) goto L23;
        ISmModel.ModelVersion r0 = this.mSmVersion;
        r3 = true;
        if (r0 == ISmModel.ModelVersion.VERSION_3_0) goto L22;
        if (r0 == ISmModel.ModelVersion.VERSION_4_0) goto L22;
        if (r0 == ISmModel.ModelVersion.VERSION_5_0) goto L22;
        if (r0 == ISmModel.ModelVersion.VERSION_6_0) goto L22;
        if (r0 == ISmModel.ModelVersion.VERSION_7_0) goto L22;
        if (getAllUsers().size() < 3) goto L24;
    L22:
        if (getAllUsers().size() <= 0) goto L24;
        goto L23
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public boolean isUdkSm() {
        String r0 = getSoundModelPrettyKeyphrase();
        ArrayList<String> r1 = ExtendedSmMgr.getPDKkeyphraseList();
        boolean r4 = true;
        if (r1.isEmpty() == true) goto L5;
        Iterator<String> r2 = r1.iterator();
    L13:
        if (r2.hasNext() == false) goto L19;
        String r3 = r2.next();
        if (r0 == null) goto L13;
        if (r0.equalsIgnoreCase(r3) == false) goto L13;
    L10:
        r4 = false;
    L19:
        LogUtils.d(this.TAG, "isUdkSm: isUdkSm = " + r4, new Object[0]);
        return r4;
    L5:
        if ("Hey Snapdragon".equalsIgnoreCase(r0) == true) goto L10;
        if ("ni hao xiao long".equalsIgnoreCase(r0) == true) goto L10;
        if ("HeySnapdragon_flt10p100".equalsIgnoreCase(r0) == false) goto L19;
        goto L10
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public String getSoundModelFullFileName() {
        return this.mSmFullFileName;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public List<IKeyphraseModel> getSoundModelKeyphraseList() {
        return this.mSmKeyphraseList;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public String getSoundModelPrettyFileName() {
        return this.mSmPrettyFileName;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public String getSoundModelPrettyKeyphrase() {
        return this.mSmPrettyKeyphrase;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public String getSoundModelSuffix() {
        return this.mSmSuffix;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public int getSoundModelType() {
        return this.mSmType;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public UUID getSoundModelUUID() {
        return this.mSmUUID;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public ISmModel.ModelVersion getSoundModelVersion() {
        return this.mSmVersion;
    }

    public SmModel(String r4) {
        this.HEY_SNAPDRAGON = "Hey Snapdragon";
        this.NI_HAO_XIAO_LONG = "ni hao xiao long";
        this.HEY_SNAPDRAGON_3_0 = "HeySnapdragon_flt10p100";
        this.TAG = "SmModel";
        this.mSmVersion = ISmModel.ModelVersion.VERSION_2_0;
        this.mSmKeyphraseList = new ArrayList();
        this.mSmFullFileName = r4;
        this.mSmPrettyFileName = r4.substring(0, r4.indexOf("."));
        this.mSmSuffix = r4.substring(r4.lastIndexOf(46));
        this.mSmUUID = UUID.randomUUID();
        LogUtils.d("SmModel", "SmModel: mSmFullFileName = " + this.mSmFullFileName + " mSmSuffix = " + this.mSmSuffix + " mSmUUID = " + this.mSmUUID, new Object[0]);
    }

    private String maskUserIdForLog(int r4) {
        String r5 = String.valueOf(r4);
        return "****" + r5.substring(Math.max(0, r5.length() - 4));
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public IKeyphraseModel getKeyphraseModel(String r5) {
        LogUtils.d(this.TAG, "getKeyphraseModel: keyphrase = " + r5, new Object[0]);
        if (r5 != null) goto L6;
        LogUtils.d(this.TAG, "getKeyphraseModel: invalid input param", new Object[0]);
        return null;
    L6:
        Iterator<IKeyphraseModel> r1 = this.mSmKeyphraseList.iterator();
    L8:
        if (r1.hasNext() == false) goto L16;
        IKeyphraseModel r2 = r1.next();
        if (r2.getKeyphraseFullName().equalsIgnoreCase(r5) == false) goto L8;
        return r2;
    L16:
        return null;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public String getKeyphraseNameById(int r5) {
        Iterator<IKeyphraseModel> r0 = this.mSmKeyphraseList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IKeyphraseModel r1 = r0.next();
        if (r1.getKeyphraseId() != r5) goto L4;
        String r2 = r1.getKeyphraseFullName();
    L9:
        LogUtils.d(this.TAG, "getKeyphraseNameById: id = " + r5 + " keyphraseName = " + r2, new Object[0]);
        return r2;
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void removeKeyphrase(String r5) {
        LogUtils.d(this.TAG, "removeKeyphrase: keyphrase = " + r5, new Object[0]);
        if (r5 != null) goto L6;
        LogUtils.d(this.TAG, "removeKeyphrase: invalid input param", new Object[0]);
        return;
    L6:
        IKeyphraseModel r6 = getKeyphraseModel(r5);
        if (r6 == null) goto L10;
        this.mSmKeyphraseList.remove(r6);
        return;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void setSoundModelFullFileName(String r1) {
        this.mSmFullFileName = r1;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void setSoundModelPrettyFileName(String r1) {
        this.mSmPrettyFileName = r1;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void setSoundModelPrettyKeyphrase(String r1) {
        this.mSmPrettyKeyphrase = r1;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void setSoundModelSuffix(String r1) {
        this.mSmSuffix = r1;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void setSoundModelType(int r1) {
        this.mSmType = r1;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void setSoundModelVersion(ISmModel.ModelVersion r1) {
        this.mSmVersion = r1;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void addKeyphrase(String r5, int r6) {
        LogUtils.d(this.TAG, "addKeyphrase: keyphrase = " + r5 + " keyphraseId = " + r6, new Object[0]);
        if (r5 != null) goto L5;
    L12:
        LogUtils.d(this.TAG, "addKeyphrase: invalid input param", new Object[0]);
        return;
    L5:
        if (r6 < (-1)) goto L12;
        IKeyphraseModel r0 = getKeyphraseModel(r5);
        if (r0 != null) goto L10;
        KeyphraseModel r1 = new KeyphraseModel(r5);
        r1.setKeyphraseId(r6);
        this.mSmKeyphraseList.add(r1);
        return;
    L10:
        r0.setKeyphraseId(r6);
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public boolean isUserExistForKeyphrase(String r6, String r7) {
        IKeyphraseModel r0 = getKeyphraseModel(r6);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        LogUtils.d(this.TAG, "isUserExistForKeyphrase: keyphrase = " + r6 + " userName = " + r7 + " bExist = " + r1, new Object[0]);
        return r1;
    L5:
        if (r0.getUserModel(r7) == null) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void removeUser(String r5, String r6) {
        LogUtils.d(this.TAG, "removeUser: keyphrase = " + r5 + " userName = " + r6, new Object[0]);
        if (r5 == null) goto L12;
        if (r6 == null) goto L12;
        IKeyphraseModel r0 = getKeyphraseModel(r5);
        if (r0 != null) goto L10;
        LogUtils.d(this.TAG, "removeUser: invalid keyphrase = " + r5, new Object[0]);
        return;
    L10:
        r0.removeUser(r6);
        return;
    L12:
        LogUtils.d(this.TAG, "removeUser: invalid input param", new Object[0]);
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void addKeyphraseAndUser(String r5, int r6, String r7, int r8) {
        LogUtils.d(this.TAG, "addKeyphraseAndUser: keyphrase = " + r5 + " keyphraseId = " + r6 + " userName = " + r7 + " userId = " + maskUserIdForLog(r8), new Object[0]);
        if (r5 != null) goto L5;
    L14:
        LogUtils.d(this.TAG, "addKeyphraseAndUser: invalid input param", new Object[0]);
        return;
    L5:
        if (r6 < (-1)) goto L14;
        if (r7 == null) goto L14;
        if (r8 < (-1)) goto L14;
        IKeyphraseModel r0 = getKeyphraseModel(r5);
        if (r0 != null) goto L12;
        KeyphraseModel r1 = new KeyphraseModel(r5);
        r1.setKeyphraseId(r6);
        r1.addUser(r7, r8);
        this.mSmKeyphraseList.add(r1);
        return;
    L12:
        r0.setKeyphraseId(r6);
        r0.addUser(r7, r8);
    }
}

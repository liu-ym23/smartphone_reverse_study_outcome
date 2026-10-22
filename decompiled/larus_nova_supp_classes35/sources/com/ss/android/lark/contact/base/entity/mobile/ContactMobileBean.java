package com.ss.android.lark.contact.base.entity.mobile;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.ImageView;
import android.widget.TextView;
import c9b.a;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.utils.RomUtils;
import com.ss.android.lark.contact.base.entity.mobile.util.ContactMobileUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import h9b.b;
import java.io.Serializable;
import java.util.ArrayList;
import ru7.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ContactMobileBean implements Comparable<ContactMobileBean>, Serializable {
    private static final long serialVersionUID = -9094813086945219750L;
    private boolean EnableChoose;
    private String mAbbreviation;
    private String mAvatarUri;
    private Pair<Integer, String> mCountryCodePhonePair;
    private String mEmail;
    private String mInitial;
    private String mName;
    private String mPhone;
    private String mPhoneE164;
    private int matchType;
    private String namePinYin;
    private ArrayList<String> namePinyinList;

    public final void a() {
        String r0 = ContactMobileUtils.c(this.mName);
        this.mAbbreviation = r0;
        this.mInitial = r0.substring(0, 1);
        StringBuffer r1 = new StringBuffer();
        StringBuffer r2 = new StringBuffer();
        int r3 = 0;
    L4:
        if (r3 >= this.mName.length()) goto L10;
        StringBuffer r4 = new StringBuffer();
        String r5 = this.mName.charAt(r3) + BuildConfig.FLAVOR;
        int r6 = 0;
    L7:
        if (r6 >= r5.length()) goto L9;
        String r7 = c.c(r5.charAt(r6)).toUpperCase();
        r4.append(r7);
        r2.append(r7.charAt(0));
        r1.append(r7);
        r6 = r6 + 1;
        goto L7
    L9:
        this.namePinyinList.add(r4.toString());
        r3 = r3 + 1;
        goto L4
    L10:
        this.namePinYin = r1.toString();
    }

    public String getAvatarName() {
        if (PatternProtector.compile("[A-Za-z]").matcher(this.mName).find() == false) goto L14;
        String[] r0 = this.mName.split(" ");
        if (r0.length < 2) goto L13;
        if (r0[0].toCharArray().length <= 0) goto L13;
        if (r0[r0.length - 1].toCharArray().length <= 0) goto L13;
        return (r0[0].toCharArray()[0] + BuildConfig.FLAVOR + r0[r0.length - 1].toCharArray()[0]).toUpperCase();
    L13:
        return (this.mName.toCharArray()[0] + BuildConfig.FLAVOR).toUpperCase();
    L14:
        char[] r1 = this.mName.toCharArray();
        if (r1.length < 2) goto L19;
        return (r1[r1.length - 2] + BuildConfig.FLAVOR + r1[r1.length - 1]).toUpperCase();
    L19:
        return this.mName.toUpperCase();
    }

    public String getUniquelyIdentifies() {
        return getName() + getEmail() + getPhone();
    }

    public boolean isEmail() {
        return !TextUtils.isEmpty(this.mEmail);
    }

    public String toString() {
        String r0 = "name: " + getName();
        if (isEmail() == false) goto L7;
        return r0 + ", email: " + getEmail();
    L7:
        return r0 + ", phone: " + this.mCountryCodePhonePair;
    }

    public String getEmailOrPhone() {
        if (isEmail() == false) goto L7;
        return getEmail();
    L7:
        return getPhone();
    }

    public String getEmailOrPhoneE164() {
        if (isEmail() == false) goto L7;
        return getEmail();
    L7:
        return getPhoneE164();
    }

    public boolean isAvailable() {
        if (isEmail() == false) goto L7;
        String r0 = this.mEmail;
        Token r1 = ContactMobileUtils.a;
        return b.b("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", r0);
    L7:
        return ContactMobileUtils.d(this.mCountryCodePhonePair);
    }

    public boolean isRightEmail() {
        if (isEmail() == true) goto L6;
        return false;
    L6:
        String r0 = this.mEmail;
        Token r1 = ContactMobileUtils.a;
        return b.b("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", r0);
    }

    public boolean isRightPhone() {
        if (isEmail() == false) goto L7;
        return false;
    L7:
        return ContactMobileUtils.d(this.mCountryCodePhonePair);
    }

    public String getAvatarUri() {
        return this.mAvatarUri;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public String getInitial() {
        return this.mInitial;
    }

    public String getName() {
        return this.mName;
    }

    public String getNamePinYin() {
        return this.namePinYin;
    }

    public ArrayList<String> getNamePinyinList() {
        return this.namePinyinList;
    }

    public String getPhone() {
        return this.mPhone;
    }

    public String getPhoneE164() {
        return this.mPhoneE164;
    }

    public Pair<Integer, String> getmCountryCodePhonePair() {
        return this.mCountryCodePhonePair;
    }

    public boolean isEnableChoose() {
        return this.EnableChoose;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ContactMobileBean r4) {
        if (this.mAbbreviation.equals(r4.mAbbreviation) == false) goto L6;
        return 0;
    L6:
        boolean r0 = this.mAbbreviation.startsWith("#");
        if ((r4.mAbbreviation.startsWith("#") ^ r0) == false) goto L13;
        if (r0 == false) goto L10;
        return 1;
    L10:
        return -1;
    L13:
        return getInitial().compareTo(r4.getInitial());
    }

    public boolean isMatch(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return true;
    L6:
        if (getName().contains(r3) == false) goto L9;
        return true;
    L9:
        if (getEmailOrPhone().contains(r3) == false) goto L12;
        return true;
    L12:
        if (this.namePinYin.contains(r3.toUpperCase()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public void setEnableChoose(boolean r1) {
        this.EnableChoose = r1;
    }

    public void setMatchType(int r1) {
        this.matchType = r1;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ContactMobileBean r1) {
        return compareTo2(r1);
    }

    public void cancelLoadAvatar(TextView r3, ImageView r4) {
        if (r3.getTag() == null) goto L6;
        ((AsyncTask) r3.getTag()).cancel(true);
    L6:
        if (r4.getTag() == null) goto L9;
        ((AsyncTask) r4.getTag()).cancel(true);
        return;
    }

    public void loadAvatar(TextView r2, ImageView r3) {
        if (TextUtils.isEmpty(this.mAvatarUri) == false) goto L5;
    L9:
        r2.setText(getAvatarName());
        return;
    L5:
        if (RomUtils.h() == true) goto L9;
        a r0 = new a(r2, r3, this);
        r2.setTag(r0);
        r3.setTag(r0);
        r0.execute1(new Object[0]);
    }

    public ContactMobileBean(String r2, String r3, String r4) {
        this.namePinYin = BuildConfig.FLAVOR;
        this.matchType = 0;
        this.namePinyinList = new ArrayList();
        this.EnableChoose = true;
        this.mName = r2;
        this.mAvatarUri = r3;
        this.mEmail = r4;
        a();
    }

    public ContactMobileBean(String r3, String r4, String r5, Pair<Integer, String> r6) {
        String r0 = BuildConfig.FLAVOR;
        this.namePinYin = BuildConfig.FLAVOR;
        this.matchType = 0;
        this.namePinyinList = new ArrayList();
        this.EnableChoose = true;
        this.mName = r3;
        this.mAvatarUri = r4;
        this.mPhone = r5;
        this.mCountryCodePhonePair = r6;
        if (r6 == null) goto L6;
        r0 = "+" + this.mCountryCodePhonePair.first + ((String) this.mCountryCodePhonePair.second);
    L6:
        this.mPhoneE164 = r0;
        a();
    }

    public ContactMobileBean(String r1, String r2, int r3, String r4) {
        this(r1, r2, r4, ContactMobileUtils.e(r3, r4));
    }
}

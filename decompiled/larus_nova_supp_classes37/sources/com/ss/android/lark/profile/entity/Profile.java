package com.ss.android.lark.profile.entity;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.TenantNameStatus;
import com.bytedance.lark.pb.contact.v1.GetUserProfileResponse;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class Profile implements Serializable {
    public static final String[] DEFAULT_FIELD_KEY = null;
    public static final String TYPE_ALIAS = "B-ALIAS";
    public static final String TYPE_CALENDAR = "B-CALENDARSCHEDULE";
    public static final String TYPE_CHATGROUPNICKNAME = "B-CHATGROUPNICKNAME";
    public static final String TYPE_CITY = "B-CITY";
    public static final String TYPE_DEPARTMENT = "B-DEPARTMENT";
    public static final String TYPE_DESCRIPTION = "B-DESCRIPTION";
    public static final String TYPE_EMAIL = "B-EMAIL";
    public static final String TYPE_FRIENDAPPLYREASON = "B-FRIENDAPPLYREASON";
    public static final String TYPE_FRIENDLINK = "B-FRIENDLINK";
    public static final String TYPE_GENDER = "B-GENDER";
    public static final String TYPE_KEY_POSITION = "B-POSITION";
    public static final String TYPE_KEY_UNIT = "B-UNIT";
    public static final String TYPE_LEADER = "B-LEADER";
    public static final String TYPE_MORE = "B-MORE";
    private static final long serialVersionUID = 2832176776710183791L;
    private AccessInfo accessInfo;
    private String alias;
    private String applicationReason;
    private String avatarKey;
    private GetUserProfileResponse.Company.CertificationInfo certificationInfo;
    private String city;
    private String contactApplicationId;
    private String contactToken;
    private HashMap<String, CustomProfileField> customField;
    private String department;
    private ChatterDescription description;
    private List<String> displayFieldList;
    private String email;
    private String employeeId;
    private String enName;
    private String gender;
    private int genderType;
    private String id;
    private boolean isAdmin;
    private boolean isFriend;
    private boolean isRequestUserApplied;
    private boolean isResigned;
    private boolean isTargetUserApplied;
    private boolean isTopicGroupAdmin;
    private String leaderEnName;
    private String leaderId;
    private String leaderLocalizedName;
    private String leaderName;
    private String leaderUrl;
    private String localizedName;
    private DepartmentList mDepartmentMetaList;
    private OrgUnit mOrgUnit;
    private Position mPosition;
    private String microAppProfileUrl;
    private String name;
    private String organization;
    private String profile;
    private STATUE status;
    private String tenant;
    private String tenantId;
    private TenantNameStatus tenantNameStatus;
    private WorkStatus workStatus;
    private long zenModeEndTime;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Gender {
        public static final int DEFAULT = 0;
        public static final int FEMALE = 2;
        public static final int MALE = 1;
    }

    public static final enum STATUE extends Enum<STATUE> {
        public static final STATUE ON_BUSINESS = null;
        public static final STATUE ON_DEFAULT = null;
        public static final STATUE ON_LEAVE = null;
        public static final STATUE ON_MEETING = null;
        public static final STATUE ON_UNKNOWN = null;
        public static final /* synthetic */ STATUE[] a = null;
        private int value;

        static {
            STATUE r0 = new STATUE("ON_DEFAULT", 0, 0);
            ON_DEFAULT = r0;
            STATUE r1 = new STATUE("ON_BUSINESS", 1, 1);
            ON_BUSINESS = r1;
            STATUE r3 = new STATUE("ON_LEAVE", 2, 2);
            ON_LEAVE = r3;
            STATUE r5 = new STATUE("ON_MEETING", 3, 3);
            ON_MEETING = r5;
            STATUE r7 = new STATUE("ON_UNKNOWN", 4, -1);
            ON_UNKNOWN = r7;
            a = new STATUE[]{r0, r1, r3, r5, r7};
        }

        public static STATUE[] values() {
            return (STATUE[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static STATUE forNumber(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return ON_UNKNOWN;
        L12:
            return ON_MEETING;
        L14:
            return ON_LEAVE;
        L16:
            return ON_BUSINESS;
        L18:
            return ON_DEFAULT;
        }

        public static STATUE valueOf(String r1) {
            return (STATUE) a.a(STATUE.class, r1);
        }

        public static STATUE valueOf(int r0) {
            return forNumber(r0);
        }

        public STATUE(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        DEFAULT_FIELD_KEY = new String[]{TYPE_DESCRIPTION, TYPE_CALENDAR, TYPE_CHATGROUPNICKNAME, TYPE_DEPARTMENT, TYPE_EMAIL, TYPE_LEADER, TYPE_CITY, TYPE_ALIAS, TYPE_FRIENDAPPLYREASON, TYPE_FRIENDLINK, TYPE_MORE, TYPE_KEY_UNIT, TYPE_KEY_POSITION};
    }

    public boolean hasApplicationReason() {
        return !TextUtils.isEmpty(this.applicationReason);
    }

    public boolean hasDepartment() {
        return !TextUtils.isEmpty(this.department);
    }

    public boolean hasEmail() {
        return !TextUtils.isEmpty(this.email);
    }

    public boolean hasLeader() {
        if (this.leaderName == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasProfile() {
        if (TextUtils.isEmpty(this.microAppProfileUrl) == true) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.isEmpty(this.profile) == false) goto L8;
        return false;
    }

    public boolean hasTenant() {
        return !TextUtils.isEmpty(this.tenant);
    }

    public boolean isValid() {
        if (this.id == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Profile() {
        this.id = null;
        this.name = null;
        this.enName = null;
        this.gender = null;
        this.email = null;
        this.profile = null;
        this.microAppProfileUrl = null;
        this.department = null;
        this.tenant = null;
        this.tenantId = null;
        this.organization = null;
        this.leaderName = null;
        this.leaderEnName = null;
        this.leaderUrl = null;
        this.leaderId = null;
        this.isAdmin = false;
        this.isTopicGroupAdmin = false;
        this.employeeId = null;
        this.contactToken = null;
        this.contactApplicationId = null;
        this.applicationReason = null;
        this.city = null;
        this.description = null;
        this.workStatus = null;
    }

    public AccessInfo getAccessInfo() {
        return this.accessInfo;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getApplicationReason() {
        return this.applicationReason;
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public GetUserProfileResponse.Company.CertificationInfo getCertificationInfo() {
        return this.certificationInfo;
    }

    public String getCity() {
        return this.city;
    }

    public String getContactApplicationId() {
        return this.contactApplicationId;
    }

    public String getContactToken() {
        return this.contactToken;
    }

    public HashMap<String, CustomProfileField> getCustomField() {
        return this.customField;
    }

    public String getDepartment() {
        return this.department;
    }

    public DepartmentList getDepartmentMetaList() {
        return this.mDepartmentMetaList;
    }

    public ChatterDescription getDescription() {
        return this.description;
    }

    public List<String> getDisplayFieldList() {
        return this.displayFieldList;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public String getEnName() {
        return this.enName;
    }

    public String getGender() {
        return this.gender;
    }

    public int getGenderType() {
        return this.genderType;
    }

    public String getId() {
        return this.id;
    }

    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    public boolean getIsTopicGroupAdmin() {
        return this.isTopicGroupAdmin;
    }

    public String getLeaderEnName() {
        return this.leaderEnName;
    }

    public String getLeaderId() {
        return this.leaderId;
    }

    public String getLeaderLocalizedName() {
        return this.leaderLocalizedName;
    }

    public String getLeaderName() {
        return this.leaderName;
    }

    public String getLeaderUrl() {
        return this.leaderUrl;
    }

    public String getLocalizedName() {
        return this.localizedName;
    }

    public String getMicroAppProfileUrl() {
        return this.microAppProfileUrl;
    }

    public String getName() {
        return this.name;
    }

    public OrgUnit getOrgUnit() {
        return this.mOrgUnit;
    }

    public String getOrganization() {
        return this.organization;
    }

    public Position getPosition() {
        return this.mPosition;
    }

    public String getProfile() {
        return this.profile;
    }

    public STATUE getStatus() {
        return this.status;
    }

    public String getTenant() {
        return this.tenant;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public TenantNameStatus getTenantNameStatus() {
        return this.tenantNameStatus;
    }

    public WorkStatus getWorkStatus() {
        return this.workStatus;
    }

    public long getZenModeEndTime() {
        return this.zenModeEndTime;
    }

    public boolean isFriend() {
        return this.isFriend;
    }

    public boolean isRequestUserApplied() {
        return this.isRequestUserApplied;
    }

    public boolean isResigned() {
        return this.isResigned;
    }

    public boolean isTargetUserApplied() {
        return this.isTargetUserApplied;
    }

    public void setAccessInfo(AccessInfo r1) {
        this.accessInfo = r1;
    }

    public void setAlias(String r1) {
        this.alias = r1;
    }

    public void setApplicationReason(String r1) {
        this.applicationReason = r1;
    }

    public void setAvatarKey(String r1) {
        this.avatarKey = r1;
    }

    public void setCertificationInfo(GetUserProfileResponse.Company.CertificationInfo r1) {
        this.certificationInfo = r1;
    }

    public void setCity(String r1) {
        this.city = r1;
    }

    public void setContactApplicationId(String r1) {
        this.contactApplicationId = r1;
    }

    public void setContactToken(String r1) {
        this.contactToken = r1;
    }

    public void setCustomField(HashMap<String, CustomProfileField> r1) {
        this.customField = r1;
    }

    public void setDepartment(String r1) {
        this.department = r1;
    }

    public void setDepartmentMetaList(DepartmentList r1) {
        this.mDepartmentMetaList = r1;
    }

    public void setDescription(ChatterDescription r1) {
        this.description = r1;
    }

    public void setDisplayFieldList(List<String> r1) {
        this.displayFieldList = r1;
    }

    public void setEmail(String r1) {
        this.email = r1;
    }

    public void setEmployeeId(String r1) {
        this.employeeId = r1;
    }

    public void setEnName(String r1) {
        this.enName = r1;
    }

    public void setGender(String r1) {
        this.gender = r1;
    }

    public void setGenderType(int r1) {
        this.genderType = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setIsAdmin(boolean r1) {
        this.isAdmin = r1;
    }

    public void setIsFriend(boolean r1) {
        this.isFriend = r1;
    }

    public void setIsRequestUserApplied(boolean r1) {
        this.isRequestUserApplied = r1;
    }

    public void setIsResigned(boolean r1) {
        this.isResigned = r1;
    }

    public void setIsTargetUserApplied(boolean r1) {
        this.isTargetUserApplied = r1;
    }

    public void setIsTopicGroupAdmin(boolean r1) {
        this.isTopicGroupAdmin = r1;
    }

    public void setLeaderEnName(String r1) {
        this.leaderEnName = r1;
    }

    public void setLeaderId(String r1) {
        this.leaderId = r1;
    }

    public void setLeaderLocalizedName(String r1) {
        this.leaderLocalizedName = r1;
    }

    public void setLeaderName(String r1) {
        this.leaderName = r1;
    }

    public void setLeaderUrl(String r1) {
        this.leaderUrl = r1;
    }

    public void setLocalizedName(String r1) {
        this.localizedName = r1;
    }

    public void setMicroAppProfileUrl(String r1) {
        this.microAppProfileUrl = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setOrgUnit(OrgUnit r1) {
        this.mOrgUnit = r1;
    }

    public void setOrganization(String r1) {
        this.organization = r1;
    }

    public void setPosition(Position r1) {
        this.mPosition = r1;
    }

    public void setProfile(String r1) {
        this.profile = r1;
    }

    public void setStatus(STATUE r1) {
        this.status = r1;
    }

    public void setTenant(String r1) {
        this.tenant = r1;
    }

    public void setTenantId(String r1) {
        this.tenantId = r1;
    }

    public void setTenantNameStatus(TenantNameStatus r1) {
        this.tenantNameStatus = r1;
    }

    public void setWorkStatus(WorkStatus r1) {
        this.workStatus = r1;
    }

    public void setZenModeEndTime(long r1) {
        this.zenModeEndTime = r1;
    }
}

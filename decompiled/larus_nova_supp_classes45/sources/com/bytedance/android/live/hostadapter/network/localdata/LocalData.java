package com.bytedance.android.live.hostadapter.network.localdata;

import android.content.SharedPreferences;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LocalData {
    public static Key<Boolean> KEY_BOE_STATUS = null;
    public static Key<Boolean> KEY_ENABLE_WEB_OFFLINE = null;
    public static Key<String> KEY_FEED_SIMULATION_ROOMS = null;
    public static Key<Integer> KEY_FEED_SIMULATION_STYLE = null;
    public static Key<String> KEY_HISTORY_ENTER_ROOM_OPEN_ID = null;
    public static Key<String> KEY_LAST_ENTER_EPISODE_ID = null;
    public static Key<String> KEY_LAST_ENTER_EPISODE_IDS = null;
    public static Key<String> KEY_LAST_ENTER_ROOM_ID = null;
    public static Key<String> KEY_LAST_ENTER_ROOM_IDS = null;
    public static Key<String> KEY_LAST_ENTER_ROOM_OPEN_ID = null;
    public static Key<String> KEY_LAST_ENTER_ROOM_OPEN_IDS = null;
    public static Key<String> KEY_LOGIN_SESSION_KEY = null;
    public static Key<Boolean> KEY_LOGIN_STATUE = null;
    public static Key<String> KEY_LOGIN_UID = null;
    public static Key<String> KEY_LOGIN_USER_SESSION = null;
    private static final String VIRTUAL_SP = "virtual_sp";
    private static SharedPreferences sSharedPreferences;

    public static class Key<T> {
        protected String mKeyName;
        protected T mValue;
        protected Class<T> mValueType;

        public T getValue() {
            return this.mValue;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setValue(T r5) {
            this.mValue = r5;
            SharedPreferences.Editor r0 = LocalData.getEditor();
            if ((r5 instanceof Boolean) == false) goto L6;
            r0.putBoolean(this.mKeyName, ((Boolean) r5).booleanValue());
        L18:
            r0.apply();
            return;
        L6:
            if ((r5 instanceof Integer) == false) goto L9;
            r0.putInt(this.mKeyName, ((Integer) r5).intValue());
            goto L18
        L9:
            if ((r5 instanceof Long) == false) goto L12;
            r0.putLong(this.mKeyName, ((Long) r5).longValue());
            goto L18
        L12:
            if ((r5 instanceof Float) == false) goto L15;
            r0.putFloat(this.mKeyName, ((Float) r5).floatValue());
            goto L18
        L15:
            if ((r5 instanceof String) == false) goto L17;
            r0.putString(this.mKeyName, (String) r5);
            goto L18
        L17:
            r0.putString(this.mKeyName, r5.toString());
            goto L18
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void initValue(Class r4, T r5) {
            if (r4 != Boolean.class) goto L5;
        L35:
            T r6 = (T) Boolean.valueOf(LocalData.getSp().getBoolean(this.mKeyName, ((Boolean) r5).booleanValue()));
        L36:
            this.mValue = r6;
            return;
        L5:
            if (r4 == Boolean.TYPE) goto L35;
            if (r4 != Integer.class) goto L10;
        L34:
            r6 = (T) Integer.valueOf(LocalData.getSp().getInt(this.mKeyName, ((Integer) r5).intValue()));
            goto L36
        L10:
            if (r4 == Integer.TYPE) goto L34;
            if (r4 != Long.class) goto L15;
        L33:
            r6 = (T) Long.valueOf(LocalData.getSp().getLong(this.mKeyName, ((Long) r5).longValue()));
            goto L36
        L15:
            if (r4 == Long.TYPE) goto L33;
            if (r4 != Float.class) goto L20;
        L32:
            r6 = (T) Float.valueOf(LocalData.getSp().getFloat(this.mKeyName, ((Float) r5).floatValue()));
            goto L36
        L20:
            if (r4 == Float.TYPE) goto L32;
            String r1 = null;
            if (r4 != String.class) goto L28;
            SharedPreferences r7 = LocalData.getSp();
            String r0 = this.mKeyName;
            if (r5 == 0) goto L27;
            r1 = (String) r5;
        L27:
            r6 = (T) r7.getString(r0, r1);
            goto L36
        L28:
            SharedPreferences r8 = LocalData.getSp();
            String r2 = this.mKeyName;
            if (r5 == 0) goto L31;
            r1 = (String) r5;
        L31:
            r6 = (T) r8.getString(r2, r1);
            goto L36
        }

        public Key(String r1, Class<T> r2, T r3) {
            this.mKeyName = r1;
            this.mValueType = r2;
            this.mValue = r3;
            initValue(r2, r3);
        }
    }

    public LocalData() {
    }

    public static void init() {
    }

    static {
        Class r1 = Boolean.TYPE;
        Boolean r2 = Boolean.FALSE;
        KEY_LOGIN_STATUE = new Key("virtual_login_statue", r1, r2);
        KEY_LOGIN_UID = new Key("virtual_login_uid", String.class, "");
        KEY_LOGIN_SESSION_KEY = new Key("virtual_login_session_key", String.class, "");
        KEY_BOE_STATUS = new Key("virtual_boe_status", r1, r2);
        KEY_ENABLE_WEB_OFFLINE = new Key("Virtual_enable_web_offline", r1, Boolean.TRUE);
        KEY_LAST_ENTER_ROOM_ID = new Key("Virtual_last_enter_room_id", String.class, "");
        KEY_LAST_ENTER_ROOM_OPEN_ID = new Key("Virtual_last_enter_room_open_id", String.class, "");
        KEY_HISTORY_ENTER_ROOM_OPEN_ID = new Key("virtual_history_enter_room_open_id", String.class, "");
        KEY_LOGIN_USER_SESSION = new Key("VIRTUAL_LOGIN_USER_SESSION", String.class, "");
        KEY_LAST_ENTER_ROOM_IDS = new Key("Virtual_last_enter_room_ids", String.class, "");
        KEY_LAST_ENTER_ROOM_OPEN_IDS = new Key("Virtual_last_enter_room_open_ids", String.class, "");
        KEY_LAST_ENTER_EPISODE_IDS = new Key("Virtual_last_enter_episode_ids", String.class, "");
        KEY_LAST_ENTER_EPISODE_ID = new Key("Virtual_last_enter_episode_id", String.class, "");
        KEY_FEED_SIMULATION_STYLE = new Key("Virtual_KEY_FEED_SIMULATION_STYLE", Integer.class, 1);
        KEY_FEED_SIMULATION_ROOMS = new Key("Virtual_KEY_FEED_SIMULATION_ROOMS", String.class, "");
    }

    public static SharedPreferences getSp() {
        if (sSharedPreferences != null) goto L6;
        sSharedPreferences = BDLiveSdk.getContext().getSharedPreferences(VIRTUAL_SP, 0);
    L6:
        return sSharedPreferences;
    }

    public static SharedPreferences.Editor getEditor() {
        return getSp().edit();
    }
}

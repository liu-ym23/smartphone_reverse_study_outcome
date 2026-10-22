package com.ss.android.lark.framework.assembly.setting_handler;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.util.share_preference.UserSP;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(kpb.a.class)
public class ILarkSettingExportDependencyImpl implements kpb.a {
    private static final String LARKSETTING_EXPORT_SP_NAME = "larksetting_export";
    private static final String LARKSETTING_SP_DOMAIN = "core";
    private static final String TAG = "ILarkSettingExportDependencyImpl";

    public class a implements kpb.a.c {
        public final /* synthetic */ ILarkSettingExportDependencyImpl a;

        public a(ILarkSettingExportDependencyImpl r1) {
            this.a = r1;
        }

        @Override // kpb.a.b
        public final void remove(String r2) {
            ILarkSettingExportDependencyImpl.access$000(this.a).remove(r2);
        }

        @Override // kpb.a.b
        public final String getString(String r2, String r3) {
            return ILarkSettingExportDependencyImpl.access$000(this.a).getString(r2, r3);
        }

        @Override // kpb.a.b
        public final void putString(String r2, String r3) {
            ILarkSettingExportDependencyImpl.access$000(this.a).putString(r2, r3);
        }
    }

    public class b implements kpb.a.InterfaceC0291a {
        public final /* synthetic */ ILarkSettingExportDependencyImpl a;

        public b(ILarkSettingExportDependencyImpl r1) {
            this.a = r1;
        }

        @Override // kpb.a.b
        public final void remove(String r2) {
            ILarkSettingExportDependencyImpl.access$100(this.a).remove(r2);
        }

        @Override // kpb.a.b
        public final String getString(String r2, String r3) {
            return ILarkSettingExportDependencyImpl.access$100(this.a).getString(r2, r3);
        }

        @Override // kpb.a.b
        public final void putString(String r2, String r3) {
            ILarkSettingExportDependencyImpl.access$100(this.a).putString(r2, r3);
        }
    }

    public ILarkSettingExportDependencyImpl() {
    }

    private KVRepo getLarkSettingExportLarkRepo() {
        return LarkKVStorage.f(new com.ss.android.lark.storage.a(LARKSETTING_SP_DOMAIN), LARKSETTING_EXPORT_SP_NAME, new n6c.a(eac.a.a()));
    }

    private KVRepo getLarkSettingExportUserRepo() {
        return LarkKVStorage.o(new com.ss.android.lark.storage.a(LARKSETTING_SP_DOMAIN), LARKSETTING_EXPORT_SP_NAME, new n6c.a(UserSP.getInstance()));
    }

    @Override // kpb.a
    public kpb.a.InterfaceC0291a getLarkRepo() {
        return new b(this);
    }

    @Override // kpb.a
    public kpb.a.c getUserRepo() {
        return new a(this);
    }

    public static /* synthetic */ KVRepo access$000(ILarkSettingExportDependencyImpl r0) {
        return r0.getLarkSettingExportUserRepo();
    }

    public static /* synthetic */ KVRepo access$100(ILarkSettingExportDependencyImpl r0) {
        return r0.getLarkSettingExportLarkRepo();
    }
}

package com.obric.memorydata.middleware.impl.settings;

import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.livecard.api.impl.IslandImpl;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.middleware.api.settings.AutoMemoryRecommendItem;
import com.obric.memorydata.middleware.api.settings.AutoMemoryRecommendMemoryInfo;
import com.obric.memorydata.middleware.api.settings.AutoMemoryRecommendSection;
import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0000H\u0016R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u00020\u000e8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\b8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u000e8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0016\u0010\u001a\u001a\u00020\u001b8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\nR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\nR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\nR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\nR\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\nR\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020'0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020'0\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\nR\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\nR\u0016\u0010/\u001a\u0002008\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u000e8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0010R\u0016\u00105\u001a\u00020\u001b8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001d¨\u00067"}, d2 = {"Lcom/obric/memorydata/middleware/impl/settings/RecommendSettings;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "Lcom/obric/memorydata/middleware/api/settings/IRecommendSettings;", "<init>", "()V", "create", "profileTag", "", "", "getProfileTag", "()Ljava/util/List;", "proactiveEnableDid", "getProactiveEnableDid", "maxWaitUploadScreenshotCount", "", "getMaxWaitUploadScreenshotCount", "()I", "qualityCompressRation", "getQualityCompressRation", "resolutionCompressRation", "getResolutionCompressRation", "imageStyle", "getImageStyle", "()Ljava/lang/String;", "heifQuality", "getHeifQuality", "screenshotCaptureDelta", "", "getScreenshotCaptureDelta", "()J", "uxpEnableDid", "getUxpEnableDid", "ignorePackages", "getIgnorePackages", "blackPackages", "getBlackPackages", "autoMemoryEnableDid", "getAutoMemoryEnableDid", "DEFAULT_AUTO_MEMORY_RECOMMEND_JSON", "Lcom/obric/memorydata/middleware/api/settings/AutoMemoryRecommendItem;", "autoMemoryRecommend", "getAutoMemoryRecommend", "DEFAULT_AUTO_MEMORY_PRESET_RULES", "autoMemoryPresetRules", "getAutoMemoryPresetRules", "collectDid", "getCollectDid", "imageFilterEnable", "", "getImageFilterEnable", "()Z", "observationCollectViewTree", "getObservationCollectViewTree", "screenshotSamplingIntervalSeconds", "getScreenshotSamplingIntervalSeconds", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i implements IRecommendSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("profileTag")
    private final List<String> f11865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("proactiveEnableDid")
    private final List<String> f11866b;

    @SerializedName("maxWaitUploadScreenshotCount")
    private final int c;

    @SerializedName("qualityCompressRation")
    private final int d;

    @SerializedName("resolutionCompressRation")
    private final int e;

    @SerializedName("imageStyle")
    private final String f;

    @SerializedName("heifQuality")
    private final int g;

    @SerializedName("screenshotCaptureDelta")
    private final long h;

    @SerializedName("uxpEnableDid")
    private final List<String> i;

    @SerializedName("ignorePackages")
    private final List<String> j;

    @SerializedName("blackPackages")
    private final List<String> k;

    @SerializedName("autoMemoryEnableDid")
    private final List<String> l;
    private final List<AutoMemoryRecommendItem> m;

    @SerializedName("autoMemoryRecommend")
    private final List<AutoMemoryRecommendItem> n;
    private final List<AutoMemoryRecommendItem> o;

    @SerializedName("autoMemoryPresetRules")
    private final List<AutoMemoryRecommendItem> p;

    @SerializedName("collectDid")
    private final List<String> q;

    @SerializedName("imageFilterEnable")
    private final boolean r;

    @SerializedName("observationCollectViewTree")
    private final int s;

    @SerializedName("screenshotSamplingIntervalSeconds")
    private final long t;

    public i() {
        this.f11865a = CollectionsKt.listOf(new String[]{IRecommendSettings.ProfileTag.ALL, IRecommendSettings.ProfileTag.PERSONAL_INFO, IRecommendSettings.ProfileTag.PREFERENCES, IRecommendSettings.ProfileTag.HOBBIES_AND_INTERESTS, IRecommendSettings.ProfileTag.HABITS_AND_ROUTINES, IRecommendSettings.ProfileTag.FAMILY_RELATIONSHIPS, IRecommendSettings.ProfileTag.SOCIAL_RELATIONSHIPS, IRecommendSettings.ProfileTag.GOALS, IRecommendSettings.ProfileTag.PAIN_POINTS, IRecommendSettings.ProfileTag.OTHER});
        this.f11866b = CollectionsKt.emptyList();
        this.c = 3000;
        this.d = 50;
        this.e = 40;
        this.f = "heif";
        this.g = 35;
        this.i = CollectionsKt.listOf(new String[]{"1232977344129575", "3886140401655532", "3678294050879180", "3256073851770024", "3062578629095498", "2587589842597545", "1444100021429915", "3607914021681684", "1480406648226171", "4396326309116563", "2077418975928106", "705210757963291", "2429245648028460", "3727818286514249", "142277028637451", "3164865051524268", "1866285476511033", "388551813910183", "1936681585897321", "3956521569097561", "986703378798475", "1707986598272041", "4188479896946442", "1584815415065707", "3921331478674675", "740412835565451", "2253315423923787", "2728330918697739", "3924606667197931", "159859371966768", "4047724344273576", "1760762893975082", "670047355346825", "3836650253729434", "1268153236889303", "951494695487116", "2341296394838234", "3396826542967259", "2253335467436089", "1145026733170588", "2675546892548057", "582076748806864", "1074659010813786", "3924593134031323", "1989452705312794", "4487543107119771", "3132944756813451", "1795938620896393", "1866307440258697", "2781103628232171", "775591134758970", "3519972856832826", "2816285416102376", "1426503168472970", "2499625027898092", "1320948573716587", "107088796722649", "4012554127965545", "3924593131920825", "353378345198362", "4258843644997353", "3502380677100585", "177457561362041", "1373726288936858", "3449603070887563", "2165359039742240", "1232977344129575", "508454458375388", "195030287138107", "1541788953817", "3836650253729434", "1391318784547001", "1268153236889303", "951494695487116", "933901697030608", "1215376670620667", "1989435702706442", "2710715476489063", "388546857090203", "2341296394838234", "3396826542967259", "2253335467436089", "2693140206876439", "1145026733170588", "3449603070887563", "2675546892548057", "582076748806864", "1074659010813786", "3924593134031323", "1989452705312794", "4487543107119771", "3132944756813451", "1795938620896393", "1866307440258697", "2781103628232171", "1373726288936858", "775591134758970", "3519972856832826", "2816285416102376", "1426503168472970", "2499625027898092", "1320948573716587", "107088796722649", "4012554127965545", "3924593131920825", "353378345198362", "4258843644997353", "3502380677100585", "177457561362041", "3660717856393035", "3695905098187195", "300611692205594", "2851478645557514", "1760762893975082", "4135708010525179", "1162628557706826", "265428379933543", "2833886233013642", "3449614051328617", "898747094540026", "1778355360045258", "2165384568155947", "898747386053636", "2728333120144361", "1743172674284619", "2657964382514762", "2411674021461403", "1127445505321481", "476533309632377", "2288529786038570", "705231722193674", "4452368671613802", "318204921832377", "3308875477266042", "2077422459608633", "2587596949325274", "2904254992122553", "1444104815035722", "2042237874609467", "159874169703002", "230245108322539", "652458582129433", "3959786146133435", "3625534608961079", "3994971832333632", "3027400294714491", "353388015399433", "3678312483063035", "3713495800278585", "2218159726145897", "687639543162923", "2992217189878730", "1127448040995817", "705231735497273", "828378293827288", "2024646017551177", "1936685328238736", "2095014427253115", "3766272099654795", "969115565358074", "2306121946411850", "1567250164239177", "1549656651508123", "634862975614826", "2200567550857402", "1954277156205434", "3150547717753355", "2059830611938250", "3432022942963498", "1602434542869434", "2042237876479627", "1232998605567610", "2728334561440202", "3414428630140871", "406166234999440", "107097403736187", "4170892617467178", "19136467973148", "3643128075533739", "3766273122282474", "3625534604217947", "2886664125164727", "2059830046768185", "599678609541568", "1004298901674042", "89505209254619", "546902320652410", "1232997310300299", "3766272368603019", "793194663821083", "4258853306770059", "670047355346825", "2833886472063465", "4118115826533913", "3519987486039371", "4206076758157587", "4311635956379402", "388578222547755", "3484802048918843", "1602439098698026", "3256104915607017", "71918961608804", "1338556694161387", "4047752984032976", "1550303940795", "2200573794584252", "705238128459515", "2446829670947769", "2411680010617578", "494095646647380", "4223674435305211", "283024188879961", "1057081319013739", "634834154738339", "1320963117445401", "4206076756756809", "2763521650085161", "1250595727482010", "3924606667197931", "3220919212087082", "3027405196003929", "4030160740594537", "3431992112261433", "3625539535690009", "828382980372074", "2024618653433115", "1039489144273387", "2833892174518922", "1690363655646585", "617277034617865", "2007034243085578", "3080182354982217", "511717680905004", "19142351271288", "1567248852748650", "2974629749121337", "1831116675514183", "529320094236987", "89491628638666", "2798671729042745", "3731093603768715", "1620002963200576", "986712933680489", "2446863824892634", "1848729754424507", "3432025464520571", "3097775254844041", "3256104978290603", "3115367219639929", "4118121754134489", "2534819075734075", "3572764267541035", "4346820202624311", "705237275177306", "2077427150461834", "3994976743368267", "159880191425529", "1549661585093049", "388578225453915", "2218165722182235", "2605162621320041", "3220920564990809", "2781096092937625", "599651583312091", "1127450818137370", "142254377869097", "529316090249033", "1532070348722076", "1813545663089769", "1549212380377", "511689630170800", "2763522420795524", "2341310908633323", "1197790500518155", "71917941559504", "810766305857264", "670053239123066", "2482048749562249", "2939445637583658", "4417188314786186", "3203327030780553", "2341310927761915", "1549662563890139", "1760767816256346", "1479259873090137", "1672771474055019", "2517235222740217", "2869095701714105", "3731112482851737", "1514497038138228", "335820440995434", "3379269122948330", "1569262973114", "2024671039742251", "810809588504457", "3361676617871628", "2939464376164201", "2165407880893769", "933954798059882", "2218184468428329", "168639041908296", "1690418846153162", "4153324961295466", "722849028410682", "1109878429479849", "1391351737403322", "4311654613134345", "1004323995147066", "283044061478170", "3783888714105403", "3256124174598905", "3361676411868395", "71937806846266", "4285212714894969", "1127469181071895", "1936710485424443", "3713520630797483", "1549681408636314", "2235776657271175", "3080201450136058", "2341330142113163", "2957056510275875", "2640397549993418", "3203346890281241", "195083118100570", "2798726886211291", "1057100159531898", "775625122280395", "3731112467909883", "4065363908134057", "1338575904068634", "371004892021625", "388597144390457", "582111538504666", "3045018893032090", "2235776665653130", "529334603113434", "4241286223671754", "3959810941270361", "2411698201897515", "3643152265663786", "3959810736313659", "4030179664277946", "2253369094762585", "740441087045344", "3520007229932075", "3977394840949626", "4311626682220875", "1936684366993946", "3783880794465178", "4241286223671754", "2798726886211291", "1338575904068634", "1057100159531898", "2411698201897515", "529334603113434", "3959810736313659", "3731112467909883", "775625122280395", "3643152265663786", "388597144390457", "3080201450136058", "3203346890281241", "3959810941270361", "3713520630797483", "195083118100570", "740441087045344", "3045018893032090", "2235776665653130", "1549681408636314", "2640397549993418", "2341330142113163", "2235776657271175", "582111538504666", "168639041908296", "371004892021625", "3520007229932075", "4030179664277946", "2957056510275875", "1839898855004665", "2807480908579466", "1083446558753657", "45507185749802", "889932465048704", "1663988481437451", "3458391394001691", "151060763691034", "573273671776186", "1435290683069177", "3581536679327418", "1347329380619275", "1716764906412043", "3282469677988762", "2807480526115401", "3423207313909248", "2508411852593723", "3212102520833881", "45507689345674", "3880604112783979", "2121385303131163", "1435290016964905", "379758859804874", "1013077549309593", "3076913785268187", "177482655889705"});
        this.j = CollectionsKt.listOf(new String[]{"com.android.launcher3", "com.android.permissioncontroller", IslandImpl.LIVE_CARD_HOST, BuildConfig.LIBRARY_PACKAGE_NAME, "com.bytedance.android.input", "com.obric.recorder", "com.obric.lifelog", "com.obric.proactive"});
        this.k = CollectionsKt.emptyList();
        this.l = CollectionsKt.listOf(new String[]{"828373756895466", "3695902559109018", "1461715462324795", "942724759174553", "2640388685563963", "3836612757241015", "714015291279113", "1584815415065707", "1109846369031241", "2042209786952442", "1268153236889303", "3889418046331034", "3836643640120745", "3256073851770024", "3889418790861051", "3326467707819578", "2728330918697739", "1188996460325417", "4074146279194985", "2543627129078907", "3889418790861051", "168681010386516", "643639181202842", "2059805602873945", "3889418790861051", "1980678159247155", "2262155687948023", "1224216359219019", "133501176559273", "3792675521973209", "1382546672759609", "3933413256272762", "3863044512833417", "1505688465185691"});
        List<AutoMemoryRecommendItem> r1 = CollectionsKt.listOf(new AutoMemoryRecommendItem[]{new AutoMemoryRecommendItem("记账", "记录支出或收入\n标题记录支出或收入的金额\n内容里用markdown记录消费类型、渠道、商品名称等具体信息", "记录收支金额、类型和渠道", "finance_1", "blue", null, null, null, null, null, null, null, null, null, null, null, 65504, null), new AutoMemoryRecommendItem("好友生日", "朋友的生日，无论是对话里提及的还是朋友圈刷到的都要记录。\n标题记录朋友的姓名或昵称；\n总结里需要记录生日的具体日期和星座", "收纳好友生日、星座等信息", "life_cake", "purple", null, null, null, null, null, null, null, null, null, null, null, 65504, null), new AutoMemoryRecommendItem("AI 通讯录", "发生明确社交互动的人物和基本信息，比如社交聊天或者发短信等，只是朋友圈刷到的话不用记。\n标题记录人物姓名或昵称；\n内容里需要用markdown记录人物的基本信息，包括但不限于和我的关系、性别、职业、年龄、生日、家庭地址、邮箱等", "记录人物关系和基本信息", "relationship_party_1", "green", null, null, null, null, null, null, null, null, null, null, null, 65504, null), new AutoMemoryRecommendItem("读书笔记", "微信公众号和微信读书中划线的内容\n标题要记文章名称或书名；\n内容只包含划线内容就行，不要带其他多余信息", "自动收纳划线内容，沉淀阅读灵感", "business_4", "blue", null, null, null, null, null, null, null, null, null, null, null, 65504, null), new AutoMemoryRecommendItem("约定承诺", "记录和朋友约定的事项\n标题里需要展示好友名称和事项名称，比如与谁要干什么；\n内容要包括好友的名称、约定时间、约定地点、注意事项，约定的时间要转换成具体的日期", "记录和朋友的约定事项", "relationship_support", "orange", null, null, null, null, null, null, null, null, null, null, null, 65504, null), new AutoMemoryRecommendItem("人生首次", "记录我第一次做的事情或经历，必须明确是第一次才记录\n标题记录事件或经历的名称；\n总结里记录具体的事件或经历过程，以及我个人表达的感受或其他信息，用markdown输出", "记录首次经历和感受", "life_milestone", "cyan", null, null, null, null, null, null, null, null, null, null, null, 65504, null)});
        this.m = r1;
        this.n = r1;
        List<AutoMemoryRecommendItem> r2 = CollectionsKt.listOf(new AutoMemoryRecommendItem[]{new AutoMemoryRecommendItem("收支记账", "仅记录用户本人新产生的核心收支行为，如消费、转账、扫码支付、微信收发红包等。明确排除优惠券、卡包等非核心项，不予记录。购买基金、股票等投资行为也不记录。如识别到转入和转出都是用户自己的账户（如银行卡转零钱、本人名下卡片互转）也不记录。其中活动红包（如看短剧、抽奖奖励等）需判断金额是否实际落在各个APP的钱包、银行卡，若实际入账则记录。\n需要记录收入或支出的金额、收支类型（本次收支行为所属的行业或场景，如餐饮美食）、消费渠道（购买商品/服务的平台，不是支付渠道）、商品名称、交易时间（如能准确判断就精确到秒）、交易对象（如转账给某人）等与本次收支相关的全部具体信息。\n标题需直接标注收支属性和对应金额，收入以“+”开头，支出以“-”开头，后缀带上金额单位元，格式如“+50元”、“-20元”。\n副标题需明确记录本次收支的收支类型。\n需要判断是否是同一笔支出或收入，如果是的话不需要新增或更新。不是的话，每次产生新的收支行为时新增一条独立记录，不修改原有已生成的收支记录。", "记录收支金额、类型和渠道", "finance_1", "blue", new AutoMemoryRecommendMemoryInfo("收支记账", "仅记录用户本人新产生的核心收支行为，如消费、转账、扫码支付、微信收发红包等。明确排除优惠券、卡包等非核心项，不予记录。购买基金、股票等投资行为也不记录。如识别到转入和转出都是用户自己的账户（如银行卡转零钱、本人名下卡片互转）也不记录。其中活动红包（如看短剧、抽奖奖励等）需判断金额是否实际落在各个APP的钱包、银行卡，若实际入账则记录。", new AutoMemoryRecommendSection("具体记忆的内容", CollectionsKt.listOf(new String[]{"金额", "收支类型", "消费渠道", "商品名称", "交易时间", "交易对象"})), null, "判断为同一笔收支时不更新不新增，非同一笔新收支行为新增独立记录，不修改原有记录", "(收入则+，支出则-){金额}元", "{收支类型}", null, 136, null), null, null, null, null, null, null, null, null, null, 2L, 32704, null), new AutoMemoryRecommendItem("AI 通讯录", "在用户正在与他人进行对话时，且对话中有用户好友基本信息的情况下触发记忆；或在用户查看社交媒体通讯录界面（如个人主页、通讯录/聊天列表）、社交媒体好友圈时，且页面上有用户好友基本信息（只有姓名/昵称不算）的情况下触发记忆。\n不需要记录的情况：查看历史的对话记录，用户仅查看但未参与对话的群聊，跟商家/客服的对话，用户好友的社交媒体分享内容中提及他人基本信息，用户在公众社交媒体平台浏览或单向关注的人。\n需要记录发生社交互动且有以下信息增益的人物姓名或昵称，以及该人物的基本信息：包括与用户的关系（包括但不限于家人、朋友、同事、同学等）、性别、职业、年龄、生日（MM月DD日，如果是农历也可以用传统表达；如果出生年份明确，可以加上出生年份）、家庭地址、邮箱等相关内容，如有其他人物基本信息可以拓展。但只记人物的信息，不要记录具体互动的行为。没有的基本信息不展示即可。\n标题直接记录该社交互动涉及的人物姓名（常用昵称），没有姓名则直接展示昵称，如均没有则展示人物社交媒体名。\n副标题使用具体的关系类型，比如“同事”、“朋友”等。\n同一姓名的人物信息若后续有新增补充，直接在原有记忆中更新内容，不可新建重复姓名的记忆条目。", "记录人物关系和基本信息", "relationship_party_1", "green", new AutoMemoryRecommendMemoryInfo("AI通讯录", "在用户正在与他人进行对话时，且对话中有用户好友基本信息的情况下触发记忆；或在用户查看社交媒体通讯录界面（如个人主页、通讯录/聊天列表）、社交媒体好友圈时，且页面上有用户好友基本信息（只有姓名/昵称不算）的情况下触发记忆。不需要记录的情况：查看历史的对话记录，用户仅查看但未参与对话的群聊，跟商家/客服的对话，用户好友的社交媒体分享内容中提及他人基本信息，用户在公众社交媒体平台浏览或单向关注的人。", new AutoMemoryRecommendSection("具体记忆的内容", CollectionsKt.listOf(new String[]{"姓名/昵称", InfoCommonMemoryEntity.InfoKeyType.RELATIONSHIP, "性别", "职业", "年龄", "生日", "联系方式"})), null, "同一姓名/昵称的人物有新增补充信息时覆盖更新原记录，不同姓名/昵称的人物则新增独立记录", "{姓名/昵称}", "{关系}", null, 136, null), null, null, null, null, null, null, null, null, null, 3L, 32704, null), new AutoMemoryRecommendItem("朋友生日", "当用户在对话内容中提及或者看到的社交媒体通讯录界面（个人主页/通讯录/聊天列表）、好友圈内容中有朋友的生日相关信息时，触发记忆记录。其中微信、QQ等即时通讯软件的好友可均被视为朋友，其他社交媒体应用需满足互相关注或处于私聊界面。\n需要记录的内容为朋友的生日具体日期、对应星座。仅在能精确识别人物姓名（或常用昵称）和具体生日日期时触发记录，信息模糊或无法对应是否是朋友本人时避免误记。如果朋友仅有农历生日，难以获取出生年份对应阳历日期时，不需要记录星座。\n标题统一使用该朋友的人物姓名（常用昵称），没有姓名则直接展示昵称，如均没有则展示人物社交媒体名。\n副标题统一记录该朋友的具体生日日期。格式是MM月DD日（如果是农历也可以用传统表达；如果出生年份明确，可以加上出生年份）\n当发现已记录的朋友生日信息存在日期、星座错误，或者有更新的昵称、更准确的生日信息时，直接覆盖原有内容完成更新。", "记录朋友生日、星座等信息", "cake", "purple", new AutoMemoryRecommendMemoryInfo("朋友生日", "在用户正在与他人进行对话时，且对话中有用户好友基本信息的情况下触发记忆；或在用户查看社交媒体通讯录界面（如个人主页、通讯录/聊天列表）、社交媒体好友圈时，且页面上有用户好友基本信息（只有姓名/昵称不算）的情况下触发记忆。不需要记录的情况：查看历史的对话记录，用户仅查看但未参与对话的群聊，跟商家/客服的对话，用户好友的社交媒体分享内容中提及他人基本信息，用户在公众社交媒体平台浏览或单向关注的人。仅在能精确识别人物姓名（或常用昵称）和具体生日日期时触发记录，信息模糊或无法对应是否是朋友本人时避免误记。如果朋友仅有农历生日，难以获取出生年份对应阳历日期时，不需要记录星座。", new AutoMemoryRecommendSection("具体记忆的内容", CollectionsKt.listOf(new String[]{"朋友姓名/昵称", "生日日期", "星座"})), null, "同一朋友的生日、星座、昵称有更新或错误时，覆盖原有记录，不同朋友的生日信息则新增独立记录", "该朋友的人物姓名（常用昵称），没有姓名则直接展示昵称，如均没有则展示人物社交媒体名。", "该朋友的具体生日日期。格式是MM月DD日（如果是农历也可以用传统表达；如果出生年份明确，可以加上出生年份）", null, 136, null), null, null, null, null, null, null, null, null, null, 4L, 32704, null), new AutoMemoryRecommendItem("读书笔记", "当用户本人阅读电子书、文件或文章，且对部分文本内容执行“划线”、“高亮”、“备注”、“评论”等操作时，触发该记忆规则。\n需要记录的内容仅为原文对应操作的文本内容，和用户备注或评论的内容，不添加其他多余信息。\n标题规则为划线/高亮/备注/评论内容的摘要。\n副标题规则为记录内容所属的平台。\n更新规则为，如果是同一段划线/高亮/备注/评论内容有变的话，触发更新，否则直接新增记忆。", "自动收纳划线、备注和评论", "materials_1", "blue", new AutoMemoryRecommendMemoryInfo("读书笔记", "当用户本人阅读电子书、文件或文章，且对部分文本内容执行“划线”、“高亮”、“备注”、“评论”等操作时，触发该记忆规则。", new AutoMemoryRecommendSection("具体记忆的内容", CollectionsKt.listOf(new String[]{"原文内容", "用户备注"})), null, "如果是同一段划线/高亮/备注/评论内容有变的话，触发更新，否则直接新增记忆。", "划线/高亮/备注/评论内容的摘要", "{所属平台}", null, 136, null), null, null, null, null, null, null, null, null, null, 5L, 32704, null), new AutoMemoryRecommendItem("约定承诺", "当用户在与他人的对话中提及包含明确对方身份、具体行动内容、时间（绝对或相对）的承诺、约定、计划行动时触发记忆，三要素缺一不记录。\n需要记录：包括承诺对象、承诺内容、承诺时间、约定时间（YY年MM月DD日，HH:MM，最多精确到分钟，可以是时间段，如果是截止时间或开始时间可以加“前/后；也可以是模糊时间的文字表述）、当前状态（包括待办、已到期、已完成、已取消），或其他备注信息\n标题规则为承诺内容摘要，15字以下。\n副标题规则为承诺的时间，格式是YY年MM月DD日，HH:MM，最多可以精确到分钟。\n更新规则为到达时间时状态自动转为已到期，完成、取消、改期时直接更新原条记录，不新建记录。", "记录和朋友的约定事项", "relationship_support", "orange", new AutoMemoryRecommendMemoryInfo("约定承诺", "当用户在与他人的对话中提及包含明确对方身份、具体行动内容、时间（绝对或相对）的承诺、约定、计划行动时触发记忆，三要素缺一不记录。", new AutoMemoryRecommendSection("具体记忆的内容", CollectionsKt.listOf(new String[]{"承诺对象", "承诺内容", "承诺时间", "约定时间", "当前状态", "其他备注信息"})), null, "到达时间时状态自动转为已到期，完成、取消、改期时直接更新原条记录，不新建记录。", "{承诺内容摘要（15字以下）}", "承诺的时间，格式是YY年MM月DD日，HH:MM，最多可以精确到分钟。", null, 136, null), null, null, null, null, null, null, null, null, null, 6L, 32704, null), new AutoMemoryRecommendItem("人生首次", "当用户本人在文字、图片、消费、地点等场景中出现明确的首次行为信号，且该行为类型在用户历史记忆中未出现过、用户主观或客观信号明确指向首次时，触发记忆，涵盖即时发生的首次行为及经确认的历史首次行为。\n需要记录的内容包括首次行为描述、发生时间（格式是YY年MM月DD日，HH:MM，最多精确到分钟，可以是时间段，\n如果时间无法转换为标准时间，文字表述即可）、地点（如有）、相关人物（如有）、当时的简短感受（若来自对话）。\n标题规则为具体的首次行为内容。\n副标题规则为具体的描述或感受，限制在20字以内。\n更新规则为该类人生首次记录具备唯一性，原则上不更新。", "记录首次经历和感受", "milestone", "cyan", new AutoMemoryRecommendMemoryInfo("人生首次", "当用户本人在文字、图片、消费、地点等场景中出现明确的首次行为信号，且该行为类型在用户历史记忆中未出现过、用户主观或客观信号明确指向首次时，触发记忆，涵盖即时发生的首次行为及经确认的历史首次行为。", new AutoMemoryRecommendSection("具体记忆的内容", CollectionsKt.listOf(new String[]{"首次行为描述", "发生时间", "地点", "相关人物", "当时的简短感受"})), null, "人生首次记录具备唯一性，原则上不更新，判断依据为首次行为类型是否已记录", "{首次行为描述}", "具体的描述或感受，限制在20字以内", null, 136, null), null, null, null, null, null, null, null, null, null, 7L, 32704, null), new AutoMemoryRecommendItem("书影音清单", "当用户的浏览或对话中出现「想看、加入片单、mark、待看」等明确信号且指向具体影视作品，或是用户在豆瓣标记「想看」、在小红书或微信对话中明确表示「我想看某影视作品」、在视频App点击「稍后观看、收藏、想看」时，触发记忆。\n需要记录的内容包括作品名、作品类型（电影/剧集/综艺/纪录片等）、来源平台、推荐人（用户被动受到推荐）或推荐场景（用户主动想看）、首次想看时间（格式为YY年MM月DD日）、影视作品上映或播放年份、状态（分为想看、已看）。\n标题规则为《作品名》。\n副标题规则为类型，比如电影、电视剧。\n更新规则为用户实际观看后，通过视频App联动检测或手动标记的方式，将状态更新为「已看」并附加打分入口。", "记录想看的影视作品清单", "media_movie", "purple", new AutoMemoryRecommendMemoryInfo("书影音清单", "当用户的浏览或对话中出现「想看、加入片单、mark、待看」等明确信号且指向具体影视作品，或是用户在豆瓣标记「想看」、在小红书或微信对话中明确表示「我想看某影视作品」、在视频App点击「稍后观看、收藏、想看」时，触发记忆。", new AutoMemoryRecommendSection("具体记忆的内容", CollectionsKt.listOf(new String[]{"作品名", "作品类型", "来源平台", "推荐人或推荐场景", "首次想看时间", "上映或播放年份", "观看状态"})), null, "更新规则为用户实际观看后，通过视频App联动检测或手动标记的方式，将状态更新为「已看」并附加打分入口。", "《{作品名}》", "{作品类型（比如电影、电视剧）}", null, 136, null), null, null, null, null, null, null, null, null, null, 8L, 32704, null), new AutoMemoryRecommendItem("每日要事", "需要记录的内容：\n工作 / 学习类：任务闭环、会议、文档编辑、成果提交、课程学习等关键节点\n生活类：出行、消费、运动打卡、阅读、作息记录等可追溯的核心行为\n社交类：与亲友、伴侣、同事的重要沟通、约定、深度对话等有实质内容的互动\n情绪类：能反映当日心情的搜索、浏览、收藏、文案、笔记等行为痕迹\n决策类：行程规划、目标设定、计划调整等影响后续安排的重要行为\n不需要记忆的内容：\n广告弹窗、垃圾通知、无意义锁屏、误触操作\n无营养刷屏、无效群聊、重复碎片化浏览\n银行卡、密码、身份证等隐私信息，需自动脱敏\n记忆内容：重要事件的总结。\n标题为内容的一句话总结，不超过10个字，标题里不要记录发生时间。\n副标题记录总结，不要总结发生的时间。\n新增事件与已记录的事件相同时，更新已经发生的事件，否则新增事件。", "自动总结每天的重要事件", "calendar_1", "blue", new AutoMemoryRecommendMemoryInfo("每日要事", "需要记录的内容：\n工作 / 学习类：任务闭环、会议、文档编辑、成果提交、课程学习等关键节点\n生活类：出行、消费、运动打卡、阅读、作息记录等可追溯的核心行为\n社交类：与亲友、伴侣、同事的重要沟通、约定、深度对话等有实质内容的互动\n情绪类：能反映当日心情的搜索、浏览、收藏、文案、笔记等行为痕迹\n决策类：行程规划、目标设定、计划调整等影响后续安排的重要行为\n不需要记忆的内容：\n广告弹窗、垃圾通知、无意义锁屏、误触操作\n无营养刷屏、无效群聊、重复碎片化浏览\n银行卡、密码、身份证等隐私信息，需自动脱敏", new AutoMemoryRecommendSection("具体记忆的内容", CollectionsKt.listOf("重要事件的总结")), null, "判断依据为事件核心内容是否完全相同，若相同则覆盖更新原记录，不同则新增独立记录", "内容的一句话总结，不超过10个字，标题里不要记录发生时间", "记录总结，不要总结发生的时间", null, 136, null), null, null, null, null, null, null, null, null, null, 9L, 32704, null), new AutoMemoryRecommendItem("伴侣喜好记录", "伴侣跟我说过的他明确表达了喜欢的东西，包括具体的物品、明星人物、音乐等。\n标题记录喜欢的东西名称；\n副标题记录东西的类型，比如音乐、电影等；\n内容里要把对应原话和当时的场景记下来。对应场景如有时间，需要转换为YY年MM月DD日，HH:MM，最多精确到分钟。", "记录伴侣明确表达的喜好", "gift", "pink", new AutoMemoryRecommendMemoryInfo("伴侣喜好记录", "伴侣跟我说过的他明确表达了喜欢的东西，包括具体的物品、明星人物、音乐等。", new AutoMemoryRecommendSection("具体记忆的内容", CollectionsKt.listOf(new String[]{"原话", "当时的场景"})), null, "同一喜好名称的补充信息直接覆盖更新原记录，不同喜好则新增独立记录，判断依据为喜好名称是否一致", "{喜欢的东西名称}", "东西的类型，比如音乐、电影等", null, 136, null), null, null, null, null, null, null, null, null, null, 10L, 32704, null)});
        this.o = r2;
        this.p = r2;
        this.q = CollectionsKt.emptyList();
        this.s = 1;
        this.t = 10;
    }

    public i a() {
        return new i();
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public List<String> getAutoMemoryEnableDid() {
        return this.l;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public List<AutoMemoryRecommendItem> getAutoMemoryPresetRules() {
        return this.p;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public List<AutoMemoryRecommendItem> getAutoMemoryRecommend() {
        return this.n;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public List<String> getBlackPackages() {
        return this.k;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public List<String> getCollectDid() {
        return this.q;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public int getHeifQuality() {
        return this.g;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public List<String> getIgnorePackages() {
        return this.j;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public boolean getImageFilterEnable() {
        return this.r;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public String getImageStyle() {
        return this.f;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public int getMaxWaitUploadScreenshotCount() {
        return this.c;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public int getObservationCollectViewTree() {
        return this.s;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public List<String> getProactiveEnableDid() {
        return this.f11866b;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public List<String> getProfileTag() {
        return this.f11865a;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public int getQualityCompressRation() {
        return this.d;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public int getResolutionCompressRation() {
        return this.e;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public long getScreenshotCaptureDelta() {
        return this.h;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public long getScreenshotSamplingIntervalSeconds() {
        return this.t;
    }

    @Override // com.obric.memorydata.middleware.api.settings.IRecommendSettings
    public List<String> getUxpEnableDid() {
        return this.i;
    }
}
